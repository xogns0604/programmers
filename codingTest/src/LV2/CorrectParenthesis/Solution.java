package LV2.CorrectParenthesis;
//https://school.programmers.co.kr/learn/courses/30/lessons/12909

public class Solution {
	
	boolean solution(String s) {
        
		int check = 0;
		
		for(int i=0 ; i<s.length() ; i++) {
			if(check<0) return false;
			if(s.charAt(i) == '(') check ++;
			else check--;
		}
		
		
		
		
		return check == 0 ? true : false;
		
//		int check = 0;
//		
//		for(String str : s.split("")) {
//			if(check<0) return false;
//			if(str.equals("(")) {
//				check++;
//			}else {
//				check--;
//			}
//		}
//		
//        return check == 0 ? true : false;
    }
	
	
}
