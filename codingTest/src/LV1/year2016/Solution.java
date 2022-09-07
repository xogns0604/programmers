package year2016;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

//https://programmers.co.kr/learn/courses/30/lessons/12901


public class Solution {
	public static String solution(int a, int b) {
		
		LocalDate date = LocalDate.of(2016, a, b);
		DayOfWeek dOW = date.getDayOfWeek();
		
        String answer = dOW.getDisplayName(TextStyle.SHORT, Locale.US);
        return dOW.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
    }
	
	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		
		System.out.println(solution(a,b));
	}
}
