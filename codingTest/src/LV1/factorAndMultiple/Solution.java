package LV1.factorAndMultiple;
//https://programmers.co.kr/learn/courses/30/lessons/12940

import java.util.Arrays;

public class Solution {
	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		
		for(int i=1 ; i<=Math.min(n,m) ; i++) {
			if(n%i == 0 && m%i == 0) answer[0] = i;
		}
		
		for(int i=n*m ; i>=Math.max(m, n) ; i--) {
			if(i%n == 0 && i%m ==0) answer[1] = i;
		}
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 12)));
	}
}
