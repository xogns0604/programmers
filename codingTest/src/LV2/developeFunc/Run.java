package LV2.developeFunc;

import java.util.Arrays;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] progresses = {93, 30, 55};
//		int[] speeds = {1, 30, 5};    //2,1
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};    //2,1
		
		int[] result = new Solution().solution(progresses, speeds);
		System.out.println(Arrays.toString(result));
		
	}

}
