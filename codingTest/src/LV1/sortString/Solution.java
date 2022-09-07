package LV1.sortString;

import java.util.Arrays;
import java.util.Comparator;

//https://programmers.co.kr/learn/courses/30/lessons/12915




public class Solution {
	public static String[] solution(String[] strings, int n) {
		Arrays.sort(strings);
		
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) < o2.charAt(n))return -1;
				else if(o1.charAt(n) > o2.charAt(n)) return 1;
				else return 0;
			}
		});
		
        return strings;
    }

	public static void main(String[] args) {
		String[] strings = {"sun", "bed", "car"};
		int n =1;
		
		System.out.println(Arrays.toString(solution(strings, n)));
	}
}
