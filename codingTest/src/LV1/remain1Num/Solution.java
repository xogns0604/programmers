package remain1Num;

import java.util.stream.IntStream;

public class Solution {
	public static int solution(int n) {
		int answer = 0;
		
		for(int i=2 ; i<n; i++) {
			if(n%i == 1) {
				return i;
			}
		}
		
  
        return answer;
    }
	

	public static void main(String[] args) {
		System.out.println(solution(10));
	}
}
