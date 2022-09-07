package LV1.stringHandling;
//https://programmers.co.kr/learn/courses/30/lessons/12918

public class Solution {
	public static boolean solution(String s) {
		
		for(char c : s.toCharArray()){
			if('0'<=c && c<='9') continue;
			else return false;
		}
		
		if(s.length()!=4 && s.length()!=6) return false;
		else return true;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("a234"));
	}
}
