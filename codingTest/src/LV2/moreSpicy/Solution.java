//https://programmers.co.kr/learn/courses/30/lessons/42626

package LV2.moreSpicy;

import java.util.PriorityQueue;

public class Solution {

	 public int solution(int[] scoville, int K) {
		 
		int answer = 0;
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		for(int num : scoville) pQ.add(num);
		
		while(pQ.size() !=1) {
			if(pQ.peek() >= K) break;
			
			int num = pQ.poll() + pQ.poll()*2;
			
			pQ.add(num);
			answer++;
			
			
			if(pQ.size() == 1 && pQ.peek() < K) return -1;
		}
		
		return answer;
    }
}

/*
 * ArrayList<Integer> li = new ArrayList<>(); int answer = 0;
 * 
 * for (int num : scoville) { li.add(num); }
 * 
 * li.sort(null);
 * 
 * while(li.get(0) < K) { if(li.size() == 1) return -1; answer++; int num =
 * li.get(0) + li.get(1)*2; li.remove(0); li.remove(0);
 * 
 * li.add(num); li.sort(null); }
 * 
 * return answer;
 */