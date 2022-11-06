package LV2.BinaryTransformRepeat;
//https://school.programmers.co.kr/learn/courses/30/lessons/70129

public class Solution {
	
	public int[] solution(String s) {
        int[] answer = {0, 0};
        
        String noZeroStr = s;
        for(;;) {
        	
        	if(noZeroStr.equals("1")) {
        		break;
        	}
        	
        	System.out.println(noZeroStr);
        	
        	answer[0]++;
        	answer[1] += noZeroStr.length() - noZeroStr.replaceAll("0", "").length();
        	noZeroStr = noZeroStr.replaceAll("0", "");
        	 
        	int num = noZeroStr.length();
        	noZeroStr = Integer.toBinaryString(num);
        	
        }
        
        
        
        return answer;
    }
	
	
}
