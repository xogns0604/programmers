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
	
	//정규표현실 학습후 코딩
	//참고자료: https://velog.io/@minji/Java-%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9DString.replaceAll-%EB%A9%94%EC%84%9C%EB%93%9C%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%B9%98%ED%99%98
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
/*1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
예2	"z-+.^."	"z--"
예3	"=.="	"aaa"
예4	"123_.def"	"123_.def"
예5	"abcdefghijklmn.p"
*/