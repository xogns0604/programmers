package minimumRectangle;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/86491


public class Solution {
	public static int solution(int[][] sizes) {
		
		for(int[] i : sizes) Arrays.sort(i);
		
		int max1 = sizes[0][0];
		int max2 = sizes[0][1];
		
		for(int[] i : sizes) {
			if(i[0] > max1) max1 = i[0];
			if(i[1] > max2) max2 = i[1];
		}
		
	
 
        return max1*max2;
    }
	
	public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		
		System.out.println(solution(sizes));
	}
}
