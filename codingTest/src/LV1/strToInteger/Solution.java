package LV1.strToInteger;

public class Solution {
	public static int solution(String s) {
		
//		if(s.charAt(0) != '-') return Integer.parseInt(s.replaceAll("[^1-9]", ""));
//		else return -Integer.parseInt(s.replaceAll("[^1-9]", ""));
		
		return Integer.parseInt(s);
    }
	
	public static void main(String[] args) {
		System.out.println(solution("99999"));
		
		String str = "-231234";
		int n = Integer.parseInt(str);
		
		System.out.println(n);
	}
}
