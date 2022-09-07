package numOfK;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42748

public class Solution {
	 public static int[] solution(int[] array, int[][] commands) {
		 int[] answer = new int[commands.length];
		 
		 int i=0;
		 for(int[] com : commands) {
			int[] arr = Arrays.copyOfRange(array, com[0]-1, com[1]);
			Arrays.sort(arr);
			answer[i++] = arr[com[2]-1]; 
		 }

		 return answer;
	 }
	 
	 public static void main(String[] args) {
		 int[] array = {1, 5, 2, 6, 3, 7, 4};
		 int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		 

		 
		 System.out.println(Arrays.toString(solution(array, commands)));
	}
}
