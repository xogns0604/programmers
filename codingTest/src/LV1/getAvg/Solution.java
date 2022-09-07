package LV1.getAvg;

//https://programmers.co.kr/learn/courses/30/lessons/12944

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static double solution(int[] arr) {
    	return (double)IntStream.of(arr).map(num -> num).sum() / arr.length;
    }
    
    public static double solution2(int[] arr) {
    	return Arrays.stream(arr).average().orElse(0);
    }
    
    public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		
		System.out.println(solution2(arr));
	}
}
