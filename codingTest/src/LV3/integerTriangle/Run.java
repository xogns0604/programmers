package LV3.integerTriangle;
//https://school.programmers.co.kr/learn/courses/30/lessons/43105

public class Run {

	public static void main(String[] args) {
		
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		
		int[][] test;
		
		//int[][] triangle = {{7}, {3, 8}};
		System.out.println(new Solution().solution(triangle));
	}
}

