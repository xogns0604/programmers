package LV1.dividedNumArray;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

//https://programmers.co.kr/learn/courses/30/lessons/12910


public class Solution {
	public static int[] solution(int[] arr, int divisor) {
		Set<Integer> numSet = new TreeSet<Integer>();
		
		for(int num : arr) {
			if(num%divisor == 0) numSet.add(num);
		}
		
		if(numSet.isEmpty()) return new int[]{-1};
        return numSet.stream().mapToInt(num -> num).toArray();
    }
	
	public static int[] solution2(int[] arr, int divisor) {
		int[] answer =  Arrays.stream(arr).filter(num -> num%divisor == 0).toArray();
		if(answer.length == 0) answer = new int[] {-1};
        Arrays.sort(answer);
		return answer;
    }
	
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int divisor = 5;
		
		System.out.println(Arrays.toString(solution2(arr, divisor)));
	}
}
