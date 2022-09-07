package ternaryFlip;
//https://programmers.co.kr/learn/courses/30/lessons/68935
public class Solution {
	public static int solution(int n) {
		StringBuilder sb = new StringBuilder();
		
		while(n>=1) {
			sb.insert(0, n%3);
			n/=3;
		}

        return Integer.parseInt(sb.reverse().toString(), 3);
    }
	

	public static void main(String[] args) {
		System.out.println(solution(45));
	}
}
