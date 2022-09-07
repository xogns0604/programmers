package LV1.stringDecending;
//https://programmers.co.kr/learn/courses/30/lessons/12917

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	public static String solution(String s) {
		char[] cha = s.toCharArray();

		Arrays.sort(cha);
		
		StringBuilder sb = new StringBuilder(String.valueOf(cha));
		sb.reverse();
        return sb.toString();
    }
	
	public static String solution2(String s) {
		char[] cha = s.toCharArray();
		
		Arrays.sort(cha);
		Stream.of(cha);
		return new StringBuilder(new String(cha)).reverse().toString();
    }
	
	public static String solution3(String s) {
		//return Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
		return Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
	
	public static void main(String[] args) {
		System.out.println(solution3("Zbcdefg"));
	}
}
