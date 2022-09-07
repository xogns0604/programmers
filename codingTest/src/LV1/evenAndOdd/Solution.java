package LV1.evenAndOdd;
//https://programmers.co.kr/learn/courses/30/lessons/12937

public class Solution {
	public static String solution(int num) {
        return num%2 == 0 ? "Even" : "Odd";
    }
	
	public static void main(String[] args) {
		System.out.println(solution(3));
	}
}
