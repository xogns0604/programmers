package secretMap;
//https://programmers.co.kr/learn/courses/30/lessons/17681

import java.util.Arrays;

public class Solution {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		
		String[] answer = new String[n];
		
		for(int i=0 ; i<n ; i++) {
			String num1 = Integer.toBinaryString(arr1[i]);
			String num2 = Integer.toBinaryString(arr2[i]);
			String sum = "";
			
			if(num1.length()<n) {while(num1.length() != n) num1 = 0 + num1;}
			if(num2.length()<n) {while(num2.length() != n) num2 = 0 + num2;}
			
			for(int j=0 ; j<n; j++) {
				if(num1.charAt(j) == '1' || num2.charAt(j) == '1') sum+="#";
				else sum+=" ";
			}
						
			answer[i] = sum;
		}

        return answer;
    }
	
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		
		String[] str = solution(n, arr1, arr2);
		
		System.out.println(Arrays.toString(str));
	}
}
