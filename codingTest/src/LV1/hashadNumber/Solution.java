package LV1.hashadNumber;

import java.util.StringTokenizer;
import java.util.stream.Stream;

//https://programmers.co.kr/learn/courses/30/lessons/12947


public class Solution {
	public static boolean solution(int x) {	
        return x%(Stream.of(String.valueOf(x).split("")).mapToInt(Integer::valueOf).sum()) == 0 ? true : false;
    }
	
	
	
	public static void main(String[] args) {
		System.out.println(solution(13));
		

	}
}
