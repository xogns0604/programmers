package LV1.findPrimeNum;
//https://programmers.co.kr/learn/courses/30/lessons/12921


public class Solution {
	public static int solution(int n) {
		int answer = 1;
		
		for(int i=3 ; i<=n ; i++) {
			boolean isPrime = true;
			for(int j=2 ; j<=Math.sqrt(i) ; j++) {
				if(i%j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) answer++;
		}
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(10));
		
		
	}
}
