package Study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

////�����ڷ�
//https://so4869.tistory.com/29 �ǽ�����
//https://coding-factory.tistory.com/529 ��ȭ
public class PatternMatching {

	public static void main(String[] args) {
		String userId = "dumbalom009";
		String password = "asdf!@#$";
		
		String userIdRegex = "^[a-zA-Z0-9]{8,20}$";
		String passwordRegex = "^[a-zA-Z0-9!@#$]{8,20}$";
		//Sting.match : ��ġ���ο� ���� boolean�� ��ȯ, ��ȿ��O ���ڿ�������X
			//��ȿ�� �˻� => id : �������ڸ����� 8���ڿ��� 20���� pw : ��������Ư������(?!@#$%) 8���ڿ��� 20����
		boolean id = userId.matches(userIdRegex);
		boolean pw = password.matches(passwordRegex);
		System.out.println(id);
		System.out.println(pw);
		
		//String.replaceAll : Ư�� ������ ġȯ�ϴ� �޼ҵ� ��ȿ��O ���ڿ�������X ������ ��ȿ���� ���� ������ ����
			//1.��ȿ���˻� : ���ɸ� �ϴٰ� �˰��ְ� ������� �ʴ°� ����
		boolean id1 = userId.replaceAll(userIdRegex, "").equals("");
		boolean pw1 = password.replaceAll(passwordRegex, "").equals("");
			//2.���ڿ� ����(������)
		String str = "����� 10�� �ִ�.\r\n" + "��� 14���� �ִ�.\r\n" + "�ٳ����� 12341234���� �ִ�.";
		String regex = "([��-�R]+)[�����̰�] ([0-9]+)��.*�ִ�.";
		String result = str.replaceAll(regex, "$1, $2");
		String result2 = str.replaceAll(regex, "{\"item\": \"$1\", \"quantity\": \"$2\"}");
		System.out.println(result);
		
		
		//String.replaceFirst
			//1.��ȿ���˻�: replaceAll�� ����
			//2.���ڿ�����(������): ������
		String str1 = "�������� ���򿡼� ���η� ����մϴ�.";
		String regex1 = "([��-�R]+)[�����̰�] ([��-�R]+)���� ([��-�R]+)�� ([��-�R]+)�մϴ�.";
		System.out.println(str1.replaceFirst(regex1, "$1, $2, $3, $4"));
		
		//String.split : ��Ģ�� �����ڷ� �Ͽ� �迭�� ����
		String str2 = "�������� ��Ʈ�� ���� ��������.";
		String[] result3 = str2.split(" ");
		System.out.println(Arrays.asList(result3));
			//1.��ȿ���˻�: replaceAll�� �̿��� �ļ��̱⶧���� ���x �˾Ƹ� ����
			//2.���ڿ� ������: ���������� String.join�޼ҵ�� ������ ������ �׳� replaceAll�� ����
		
		//Pattern & Matcher ��� : �ٺ����� ���
			//1.��ȿ�� �˻� : String.match�� ����� ���
		System.out.println(Pattern.matches(userIdRegex, userId));
			//2.���ڿ� ������
		Pattern pa = Pattern.compile(regex);
		Matcher mat = pa.matcher(str);
		while(mat.find()) {
			String match = mat.group();
			String group1 = mat.group(1);
			String group2 = mat.group(2);
			System.out.println("matched string: " + match);
			System.out.println("��ȣ1: " + group1);
			System.out.println("��ȣ2: " + group2);
			System.out.println();
		}
		
		
		String email = "test@naver.com";
		boolean emch = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
		System.out.println(emch);
		/*
		 * String.match � ���ڿ��� ���� ���ϴ� �������� Ȯ���� �� ����Ѵ�.
		 * String.replaceAll � ���ڿ� ������ ��"A"�� ��"B"�� ġȯ�ϰų�, ������ ���ڿ� �����͸� ������ �� ����Ѵ�. 
		 * String.split ���� �����͸� ���ļ� �ϳ��� ���ڿ��� �ְ���� ���� �ٽ� ����� ����Ѵ�. 
		 * Pattern, Matcher �ؽ�Ʈ ���� ������ �����͸� ���Խ� ������ �̾Ƴ��� �� ���� ���� ����� �� ����Ѵ�.
		 */
	
	}
	
	
}
