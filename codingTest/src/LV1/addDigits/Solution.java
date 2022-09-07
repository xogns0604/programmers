package LV1.addDigits;
//https://programmers.co.kr/learn/courses/30/lessons/12931

import java.util.*;

import java.util.stream.*;
public class Solution {
	public static int solution(int n) {
		
		return Arrays.asList(String.valueOf(n).split("")).stream().mapToInt(Integer::parseInt).sum();

    }
	
	public static void main(String[] args) {
		Arrays.asList(String.valueOf(123).split("")).stream().mapToInt(Integer::parseInt).sum();
		
		System.out.println(Stream.of(String.valueOf(123).split("")).mapToInt(Integer::parseInt).sum());
		//System.out.println(Arrays.asList(String.valueOf(987).split("")).stream().mapToInt(Integer::parseInt).sum());
	}
}
