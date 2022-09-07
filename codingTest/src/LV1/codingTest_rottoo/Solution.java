package codingTest_rottoo;

import java.util.Arrays;
import java.util.Iterator;

//https://programmers.co.kr/learn/courses/30/lessons/77484

class Solution {
	public static int[] Solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zero = 0;
        int correct =0;
        
        for(int i=0;i<lottos.length;i++) {
        	if(lottos[i] == 0) zero++;
        	
        	for(int j : win_nums) {
        		if(lottos[i] == j) correct++;
        	}
        }

        answer[0] = 7-zero-correct;
        answer[1] = 7-correct;
        
        if(answer[0] ==7) answer[0] =6;
        if(answer[1] ==7) answer[1] =6;

        return answer;
    }
	
	public static void main(String[] args) {
		//int[] lottos = {44, 1, 0, 0, 31, 25};
		//int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] lottos = {1,2,3,4,5};
		int[] win_nums = {6,7,8,9,0};
		int[] answer = Solution(lottos,win_nums);
		
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}

	}
}
