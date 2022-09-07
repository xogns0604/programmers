package notFinishAthletes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/42576 

public class Solution {
	public static String solution(String[] participant, String[] completion) {
       Arrays.sort(participant);
       Arrays.sort(completion);
   
       for(int i=0 ; i<participant.length-1 ; i++) {
    	   if(!participant[i].equals(completion[i])) {
    		   return participant[i];
    	   }
       }
       return participant[participant.length-1];
    }
	
	public static String solution2(String[] participant, String[] completion) {
	       Map<String, Integer> nonFA = new HashMap();
	       
	       for(String str : participant) nonFA.put(str, nonFA.getOrDefault(str, 0)+1);
	       for(String str : completion) nonFA.put(str, nonFA.get(str)-1);
	       
	       String answer = "";
	       
	       for(String key : nonFA.keySet()) {
	    	   if(nonFA.get(key) != 0) answer = key;
	       }
	       return answer;
	    }
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		System.out.println(solution2(participant,completion));
	}
}
