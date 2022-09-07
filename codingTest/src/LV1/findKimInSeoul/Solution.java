package LV1.findKimInSeoul;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12919


public class Solution {
	public static String solution(String[] seoul) {
		String answer = "";
		
		for(int i=0 ; i<seoul.length ; i++) {
			if(seoul[i].equals("Kim")) {
				answer = "�輭���� " + i + "�� �ִ�";
			}
		}
		
        return answer;
    }
	
	public static String solution2(String[] seoul) {
		
		int num = Arrays.asList(seoul).indexOf("Kim");
		
        return "�輭���� " + num + "�� �ִ�";
    }
	
	public static void main(String[] args) {
		String[] seoul  = {"Jane", "Kim"};
		
		System.out.println(solution2(seoul));
	}
}
