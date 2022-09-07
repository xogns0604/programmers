package LV1.spacedNumber;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12954



public class Solution {
	public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        long sum = 0;
        for(int i=0 ; i<n ; i++) {
        	sum+=x;
        	answer[i] = sum;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2, 5)));
	}
}
