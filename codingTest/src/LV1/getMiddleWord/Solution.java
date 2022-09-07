package getMiddleWord;
//https://programmers.co.kr/learn/courses/30/lessons/12903

public class Solution {
	public static String solution(String s) {
		
		if(s.length()%2 ==1) {
			return String.valueOf(s.charAt(s.length()/2));
		}
		else {
			return s.substring(s.length()/2 -1, s.length()/2 +1);
		}
    }
	
	public static void main(String[] args) {
		String s = "qwer";
		
		System.out.println(solution(s));
	}
}
