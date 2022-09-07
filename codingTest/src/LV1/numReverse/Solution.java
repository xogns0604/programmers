package LV1.numReverse;
//https://programmers.co.kr/learn/courses/30/lessons/12932

import java.util.*;


public class Solution {
	public static int[] solution(long n) {

		String[] str = String.valueOf(n).split("");
		
		int[] answer = new int[str.length];
		
		for(int i =0 ; i<str.length ; i++) {
			answer[i] = Integer.valueOf(str[str.length-1-i]);
		}
		
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(123565)));
	}
}
