package budget;
//https://programmers.co.kr/learn/courses/30/lessons/12982

import java.util.Arrays;

public class Solution {
	public static int solution(int[] d, int budget) {
		Arrays.sort(d);
		
		int answer = 0;
		for(int i=0 ; i<d.length ; i++) {
			int sum = 0;
			for(int j=0 ; j<=i ; j++) sum+=d[j];
			
			if(sum>budget)break;
			
			answer = i+1;
		}

        return answer;
    }
	
	public static void main(String[] args) {
		int[] d = {2,2,3,3};
		int budget = 10;
		
		System.out.println(solution(d, budget));
	}
}
