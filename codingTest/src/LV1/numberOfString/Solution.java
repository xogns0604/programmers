package LV1.numberOfString;
//https://programmers.co.kr/learn/courses/30/lessons/12916


public class Solution {
	static boolean  solution(String s) {
		s = s.toLowerCase();

		int num =0;
		for(char cha : s.toCharArray()) {
			if(cha == 'p') num++;
			else if(cha == 'y') num--;
		}
		
        if(num!=0) return false;
        return true;
    }
	
	static boolean  solution2(String s) {
		s = s.toLowerCase();
		
		return s.chars().filter(e-> e=='p').count() == s.chars().filter(e-> e=='y').count();
    }
	
	public static void main(String[] args) {
		System.out.println(solution2("sPgyhYspgrherhppppppyyyyyyPPPPPPyyyYYY"));
	}
}
