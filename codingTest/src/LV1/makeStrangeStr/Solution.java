package LV1.makeStrangeStr;

import java.util.Arrays;
import java.util.regex.Pattern;

//https://programmers.co.kr/learn/courses/30/lessons/12930
	
	
public class Solution {
	public static String solution(String s) {
		s+="a";
		String[] strArr = s.split(" ");

		String answer = "";
		
		for(String arr : strArr) {
			boolean isbol = true;
			
			for(char cha : arr.toCharArray()) {
				if(isbol) {
					answer+=Character.toUpperCase(cha);
					isbol = false;
				} else {
					answer+=Character.toLowerCase(cha);
					isbol = true;
				}
			}
			
			answer+=" ";
		}
		
		return answer.substring(0, answer.length()-2);
    }
	
	public static void main(String[] args) {
		
		System.out.print("       try      hello       world   ");
		System.out.println("---------");
		System.out.print(solution("       try      hello       world   "));
		System.out.println("---------");
	
		
	}
}
