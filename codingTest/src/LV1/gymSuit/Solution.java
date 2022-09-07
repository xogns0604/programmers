package gymSuit;

import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/42862

public class Solution {
	public static int solution(int n, int[] lost, int[] reserve) {
		Map<Integer, Integer> stu = new HashMap<Integer, Integer>();
		
		for(int i=0 ; i<n ; i++) stu.put(i+1, 1);
		for(int i : lost) stu.put(i, 0);
		for(int i : reserve) stu.put(i, stu.get(i)+1);
		
//		for(int i : stu.keySet()) {
//			System.out.println(stu.get(i));
//		}
		
		
		for(int i : stu.keySet()) {
			if(stu.get(i) == 0) {
				if(stu.get(i-1) != null && stu.get(i-1) == 2) {
					stu.put(i-1, 1);
					stu.put(i, 1);
				}else if(stu.get(i+1) != null && stu.get(i+1) == 2) {
					stu.put(i+1, 1);
					stu.put(i, 1);
				}
			}
		}
		
        int answer = 0;
        
        for(int i : stu.keySet()) {
        	if(stu.get(i) > 0) answer++;
        }
        return answer;
    }
	
	
	
	
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		
		System.out.println(solution(n, lost, reserve));
	}
}
