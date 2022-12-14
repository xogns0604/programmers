package Study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

////참고자료
//https://so4869.tistory.com/29 실습예제
//https://coding-factory.tistory.com/529 심화
public class PatternMatching {

	public static void main(String[] args) {
		String userId = "dumbalom009";
		String password = "asdf!@#$";
		
		String userIdRegex = "^[a-zA-Z0-9]{8,20}$";
		String passwordRegex = "^[a-zA-Z0-9!@#$]{8,20}$";
		//Sting.match : 일치여부에 따라 boolean값 반환, 유효성O 문자열재조합X
			//유효성 검사 => id : 영문숫자만으로 8글자에서 20글자 pw : 영문숫자특수문자(?!@#$%) 8글자에서 20글자
		boolean id = userId.matches(userIdRegex);
		boolean pw = password.matches(passwordRegex);
		System.out.println(id);
		System.out.println(pw);
		
		//String.replaceAll : 특정 내용을 치환하는 메소드 유효성O 문자열재조합X 이지만 유효성은 거의 쓰이지 않음
			//1.유효성검사 : 가능만 하다고 알고있고 사용하지 않는게 좋음
		boolean id1 = userId.replaceAll(userIdRegex, "").equals("");
		boolean pw1 = password.replaceAll(passwordRegex, "").equals("");
			//2.문자열 가공(재조합)
		String str = "사과가 10개 있다.\r\n" + "배는 14개가 있다.\r\n" + "바나나는 12341234개가 있다.";
		String regex = "([가-힣]+)[은는이가] ([0-9]+)개.*있다.";
		String result = str.replaceAll(regex, "$1, $2");
		String result2 = str.replaceAll(regex, "{\"item\": \"$1\", \"quantity\": \"$2\"}");
		System.out.println(result);
		
		
		//String.replaceFirst
			//1.유효성검사: replaceAll과 동일
			//2.문자열가공(재조합): 제한적
		String str1 = "이태훈이 은평에서 종로로 출근합니다.";
		String regex1 = "([가-힣]+)[은는이가] ([가-힣]+)에서 ([가-힣]+)로 ([가-힣]+)합니다.";
		System.out.println(str1.replaceFirst(regex1, "$1, $2, $3, $4"));
		
		//String.split : 규칙을 구분자로 하여 배열을 만듬
		String str2 = "이태훈이 마트로 장을 보러갔다.";
		String[] result3 = str2.split(" ");
		System.out.println(Arrays.asList(result3));
			//1.유효성검사: replaceAll을 이용한 꼼수이기때문에 사용x 알아만 두자
			//2.문자열 재조합: 마찬가지로 String.join메소드로 가능은 하지만 그냥 replaceAll을 쓰자
		
		//Pattern & Matcher 방식 : 근본적인 방식
			//1.유효성 검사 : String.match와 비슷한 방식
		System.out.println(Pattern.matches(userIdRegex, userId));
			//2.문자열 재조합
		Pattern pa = Pattern.compile(regex);
		Matcher mat = pa.matcher(str);
		while(mat.find()) {
			String match = mat.group();
			String group1 = mat.group(1);
			String group2 = mat.group(2);
			System.out.println("matched string: " + match);
			System.out.println("괄호1: " + group1);
			System.out.println("괄호2: " + group2);
			System.out.println();
		}
		
		
		String email = "test@naver.com";
		boolean emch = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
		System.out.println(emch);
		/*
		 * String.match 어떤 문자열이 내가 원하는 형식인지 확인할 때 사용한다.
		 * String.replaceAll 어떤 문자열 내에서 값"A"를 값"B"로 치환하거나, 간단한 문자열 데이터를 가공할 때 사용한다. 
		 * String.split 여러 데이터를 합쳐서 하나의 문자열로 주고받은 것을 다시 떼어낼때 사용한다. 
		 * Pattern, Matcher 텍스트 파일 내에서 데이터를 정규식 단위로 뽑아내서 그 값을 직접 사용할 때 사용한다.
		 */
	
	}
	
	
}
