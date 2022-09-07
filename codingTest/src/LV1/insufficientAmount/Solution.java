package insufficientAmount;
//https://programmers.co.kr/learn/courses/30/lessons/82612

public class Solution {
	public static long solution(int price, int money, int count) {
        
        
        long sumPrice = 0;
        
        for(int i=1 ; i<=count ; i++) {
        	sumPrice+=price*i;
        }
        
        long answer = money - sumPrice;
        
        if(answer > 0) return 0;
        return -answer;
    }
	
	public static void main(String[] args) {
		int price = 2500;
		int money = 1000000000;
		int count = 2500;
		
		System.out.println(solution(price, money, count));
	}
}
