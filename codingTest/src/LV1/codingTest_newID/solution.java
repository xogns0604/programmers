//https://programmers.co.kr/learn/courses/30/lessons/72410
package codingTest_newID;

import java.util.Iterator;

public class solution {

	public static String solution(String new_id) {
		String id = new_id.toLowerCase();

		for(int i=0 ;i<id.length();i++) {
			char cha = id.charAt(i);
		
			if(cha>=97 && cha<=122) continue;
			else if(cha==45 || cha ==95 || cha==46) continue;
			else if(cha>=48 && cha<=57) continue;
			
			id = id.replace(String.valueOf(cha), "");
			i--;
		}

		for(int i=0; i<id.length();i++) {
			if(i==id.length()-1 && '.' == id.charAt(i)) {
				continue;
			}
			if('.' == id.charAt(i)) {
				if('.' == id.charAt(i+1)) {
					id = id.replace("..",".");
					i--;
				}
			}
		}
		
		if(id.length() == 0) {}
		else if(id.charAt(0) == '.') id = id.substring(1,id.length());
		
		if(id.length() == 0) {}
		else if(id.length() > 0 && id.charAt(id.length()-1) == '.') id = id.substring(0,id.length()-1);	
		
		if(id.length()>15) {
			id = id.substring(0,15);
			
			if(id.length() == 0) {}
			else if(id.length() > 0 && id.charAt(id.length()-1) == '.') id = id.substring(0,id.length()-1);	
		}
		
		for(;;) {
			if(id.equals("")) id = "a";
			if(id.length()<3) {
				id = id+id.charAt(id.length()-1);
			}else break;
			
		}

        return id;
    }
	
	//����ǥ���� �н��� �ڵ�
	//�����ڷ�: https://velog.io/@minji/Java-%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9DString.replaceAll-%EB%A9%94%EC%84%9C%EB%93%9C%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%B9%98%ED%99%98
	public static String solution2(String new_id) {
		String id = new_id.toLowerCase();
		
		id = id.replaceAll("[^\\w-_.]", ""); 
		id = id.replaceAll("\\.{2,}", "."); 
		id = id.replaceAll("^\\.", "");
		id = id.replaceAll("\\.$", "");
		
		if(id.equals(""))id ="a"; 
		
		if(id.length()>15) {
			id = id.substring(0,15);	
			id = id.replaceAll("\\.$", "");
		}

		while(id.length()<3) {
			if(id.length()<3) id = id+id.charAt(id.length()-1);
		}
		
        return id;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str = "z-+.^.";
		String str = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution2(str));
	}

}


// 45,95,46   97~122
/*1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
     ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
��1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
��2	"z-+.^."	"z--"
��3	"=.="	"aaa"
��4	"123_.def"	"123_.def"
��5	"abcdefghijklmn.p"
*/