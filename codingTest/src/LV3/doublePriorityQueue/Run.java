package LV3.doublePriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;

public class Run {

	public static void main(String[] args) {
		
		//String[] strs = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		String[] strs = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		System.out.println(Arrays.toString(new Solution().solution(strs)));
	}
}

