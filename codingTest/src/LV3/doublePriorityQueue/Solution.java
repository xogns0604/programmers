//https://school.programmers.co.kr/learn/courses/30/lessons/42628
package LV3.doublePriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public int[] solution(String[] operations) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(String oper : operations) {
			if(oper.equals("D 1")) {
				if(!al.isEmpty()) {
					al.sort(null);
					al.remove(al.size()-1);
				}
			} else if (oper.equals("D -1")) {
				if(!al.isEmpty()) {
					al.sort(null);
					al.remove(0);
				}
			} else {
				int num = Integer.parseInt((oper.substring(2, oper.length())));
				al.add(num);
			}
		}
		
		
		al.sort(null);
		
		int[] answer = new int[2];
		if(!al.isEmpty()) {
			answer[1] = al.get(0);
			answer[0] = al.get(al.size()-1);
		}
		
        return answer;
    }

}

// 추가/삭제를 할때 매번sort를 실행하면 효율성이 떨어질까 해서 
// 별도의 minmax관리 배열을 만드려고 했지만 더 복잡해지는거같아 sort로 코딩했더니 실행이 잘됐다.. 
