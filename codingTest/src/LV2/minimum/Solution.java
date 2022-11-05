//https://programmers.co.kr/learn/courses/30/lessons/42626

package LV2.minimum;

import java.util.Arrays;

public class Solution {

	public int solution(int []A, int []B)
    {
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int answer = 0;
		
		for(int i=0 ; i<A.length ; i++) {
			answer += A[i] * B[A.length-i-1];
		}
		
        return answer;
    }
}

