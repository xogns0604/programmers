package LV1.sumDivisor;

public class Solution {
	public static int solution(int n) {
        int answer = 0;
        
//        for(int i=1 ; i <= Math.sqrt(n) ; i++) {
//        	if(i*i == n) {
//        		answer+=i;
//        		continue;
//        	}
//        	
//        	if(n%i == 0) {
//        		answer+=i;
//        		answer+=(n/i);
//        	}
//        }
        
        for(int i=1 ; i<=n ; i++) {
        	if(n%i ==0)answer+=i;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(3000));
	}
}
