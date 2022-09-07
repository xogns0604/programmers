package LV1.CaesarPW;
//https://programmers.co.kr/learn/courses/30/lessons/12926


public class Solution {
	public static String solution(String s, int n) {
		String answer = "";
		
		for(char ch : s.toCharArray()) {
			
			if('a'<=ch && ch<='z') {
				ch = (char) ((int)ch +n);
				
				if(!('a'<=ch && ch<='z')) ch = (char) ((int)ch -26);
			}
			
			if('A'<=ch && ch<='Z') {
				ch = (char) ((int)ch +n);
				
				if(!('A'<=ch && ch<='Z')) ch = (char) ((int)ch -26);
			}
		
			answer+=ch;
		}
		
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("a b z A B Z", 25));
		
		
	}
}


//a 97 ~  z 122 
//A 65~ Z 90