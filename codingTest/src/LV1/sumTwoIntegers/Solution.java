package LV1.sumTwoIntegers;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

//https://programmers.co.kr/learn/courses/30/lessons/12912

public class Solution {
	public static long solution(int a, int b) {	
        return LongStream.rangeClosed(Math.min(a, b), Math.max(a, b)).sum();
    }
	
	public static void main(String[] args) {

		System.out.println(solution(3, 5));
	}

}
