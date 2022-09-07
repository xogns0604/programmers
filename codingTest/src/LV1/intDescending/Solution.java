package LV1.intDescending;

import java.util.Arrays;

public class Solution {
	static String str = "";
	public static long solution(long n) {
		char[] cha = String.valueOf(n).toCharArray();
		Arrays.sort(cha);
		
        return Long.parseLong(new StringBuilder(String.valueOf(cha)).reverse().toString());
    }
	
	public static long solution2(long n) {
		Long.toString(n).chars().sorted().forEach(num -> str = (char)num + str);
		
		return Long.parseLong(str);
	}
	public static void main(String[] args) {
		System.out.println(solution2(118372));
		
		int n = 118372;
		
		System.out.println(String.valueOf('5') + " d");
	}
}
