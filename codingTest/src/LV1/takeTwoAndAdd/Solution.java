package takeTwoAndAdd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://programmers.co.kr/learn/courses/30/lessons/68644



public class Solution {
	public static int[] solution(int[] numbers) {
		Set<Integer> numSet = new HashSet();
		
		for(int i=0 ; i<numbers.length-1 ; i++) {
			for(int j=i+1 ; j<numbers.length ; j++) {
				numSet.add(numbers[i]+numbers[j]);
			}
		}
	
        return numSet.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
	
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		
		System.out.println(Arrays.toString(solution(numbers)));
	}
}
