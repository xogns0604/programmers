package LV2.developeFunc;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> resultList = new ArrayList<Integer>();
		
		int comValue = 0;
		while(true) {
			for(int i=comValue ; i<progresses.length ; i++) {
				progresses[i] += speeds[i];
			}
			
			if(progresses[comValue] >= 100) {
				int comNum = 0;
				for(int i=comValue ; i<progresses.length ; i++) {
					if(progresses[comValue] >= 100) {
						comNum++;
						comValue++;
					}else break;
				}
				resultList.add(comNum);
			}
			
			if(comValue == progresses.length) break;
		}
		

        return resultList.stream().mapToInt(Integer::valueOf).toArray();
        
    }
}
