package LV1.anotherNumber;

import java.util.Arrays;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/12906

public class Solution {
	public static int[] solution(int []arr) {
		
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i=0 ; i<arr.length ; i++) {
			if(st.empty()) {
				st.push(arr[i]);
				continue;
			}
			if(st.peek() != arr[i]) st.push(arr[i]);
		}

        int[] answer = new int[st.size()];
        
        for(int i=st.size()-1 ; i>=0 ; i--) {
        	answer[i] = st.pop();
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		
		System.out.println(Arrays.toString(solution(arr)));
	}
}
