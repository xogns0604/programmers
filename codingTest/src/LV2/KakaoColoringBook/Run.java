package LV2.KakaoColoringBook;

import java.util.Arrays;

public class Run {
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, 
						   {1, 2, 2, 0}, 
                           {1, 0, 0, 1}, 
                           {0, 0, 0, 1},
                           {0, 0, 0, 3},
                           {0, 0, 0, 3}};

		int[][] picture2 = {{1, 1, 1, 2}, 
				   			{0, 0, 1, 0}, 
				   			{1, 1, 1, 0}, 
				   			{1, 0, 0, 1},
				   			{1, 2, 0, 1},
				   			{1, 1, 1, 1}};
		
		System.out.println(Arrays.toString(new Solution().solution(m, n, picture)));
		
	}
	

}
