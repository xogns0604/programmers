//https://programmers.co.kr/learn/courses/30/lessons/1835

package LV2.JadenCaseStr;

import java.util.Arrays;

public class Solution {
	public String solution(String s) {
		
		boolean check = true;
		
		String result = "";
		for(String str : s.toLowerCase().split("")) {
			if(str.equals(" ")) {
				result += " ";
				check = true;
			} else {
				if(check) {
					result += str.toUpperCase();
					check = false;
				} else {
					result += str;
				}
				
			}
		}
		
        return result;
    }
}

