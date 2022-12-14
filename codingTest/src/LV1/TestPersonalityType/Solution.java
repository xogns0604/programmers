package LV1.TestPersonalityType;

import java.util.HashMap;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/118666

public class Solution {
	public String solution(String[] survey, int[] choices) {
		Map<Character, Integer> result = new HashMap<Character, Integer>();
		String[] strs = {"RT", "CF", "JM", "AN"};
		for(int i=0 ; i<survey.length ; i++) {
			if(choices[i] > 4) {
				char cha = survey[i].charAt(1);
				int point = choices[i] - 4;
				
				result.put(cha, result.getOrDefault(cha, 0) + point);
			} else {
				char cha = survey[i].charAt(0);
				int point = 4 - choices[i];
				
				result.put(cha, result.getOrDefault(cha, 0) + point);
			}
		}

        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
        	sb.append(result.getOrDefault(str.charAt(0), 0) >= result.getOrDefault(str.charAt(1), 0) ? str.charAt(0) : str.charAt(1));
        }
     
        
       
        return sb.toString();
    }
}


//1번 지표	라이언형(R), 튜브형(T)
//2번 지표	콘형(C), 프로도형(F)
//3번 지표	제이지형(J), 무지형(M)
//4번 지표	어피치형(A), 네오형(N)
//{A=1, C=1, T=3, M=2, N=1}