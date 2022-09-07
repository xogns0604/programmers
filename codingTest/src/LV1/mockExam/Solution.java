package mockExam;
//https://programmers.co.kr/learn/courses/30/lessons/42840
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static int[] solution(int[] answers) {
		int[] peo1 = {1,2,3,4,5};
		int[] peo2 = {2,1,2,3,2,4,2,5};
		int[] peo3 = {3,3,1,1,2,2,4,4,5,5};
		
		int[] col = {0,0,0}; 
		for(int i=0 ; i<answers.length ; i++) {
			if(peo1[i%peo1.length] == answers[i])col[0]++;
			if(peo2[i%peo2.length] == answers[i])col[1]++;
			if(peo3[i%peo3.length] == answers[i])col[2]++;
		}

		int max = Arrays.stream(col).max().getAsInt();
		
		List<Integer> maxL = new ArrayList<Integer>();
		
		for(int i=0; i<col.length ; i++) {
			if(col[i] == max) maxL.add(i+1);
		}
		
		
		return maxL.stream().mapToInt(i -> i).toArray();
		/* 스트림 못써서 복잡하게 한거
		int maxPeo = 0;
		for(int i=0 ; i<col.length; i++) {
			if(max == col[i]) maxPeo++;
		}
	
		int[] answer = new int[maxPeo];
		
		int index = 0;
		for(int i=0 ; i<col.length; i++) {
			if(max == col[i]) answer[index++] = i+1;
		}
        return answer;*/
    }
	
	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2,5,2};
		//int[] answers = {1,2,3,4,5};
		
		System.out.println(Arrays.toString(solution(answers)));
	}
}
