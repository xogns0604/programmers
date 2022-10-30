//https://school.programmers.co.kr/learn/courses/30/lessons/12939
package LV2.maxmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public String solution(String s) {
        
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(String str : s.split(" ")) {
			al.add(Integer.valueOf(str));
		}
		
		Collections.sort(al);
	
        return al.get(0) + " " + al.get(al.size()-1);
    }
}




