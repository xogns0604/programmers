package LV1.dartGame;
//https://programmers.co.kr/learn/courses/30/lessons/17682

public class Solution {
	public static int solution(String dartResult) {
		String[] str = {"","",""};
		
		int index = -1;
		for(int i=0 ; i<dartResult.length() ; i++) {
			char cha = dartResult.charAt(i);
			
			if(48 <= cha && cha <= 57) {
				index++;
				str[index]+=String.valueOf(cha);
				
				if(cha == '1' && dartResult.charAt(i+1) == '0') {
					str[index]+= (String.valueOf(dartResult.charAt(i+1)));
					i++;
				}
			}else str[index]+=String.valueOf(cha);
		}
		
		int[] sum = new int[3];
		
		for(int i=0 ; i<3 ; i++) {
			
			for(int j=0 ; j<str[i].length() ; j++) {
				char cha = str[i].charAt(j);
				
				if(cha == '1' && str[i].charAt(j+1) == '0') {
					sum[i] = 10;
					j++; 
					continue;
				}
				
				if(j==0) {
					sum[i] = cha-48;
					continue;
				}
				
				if(cha == 'D') sum[i] = (int) Math.pow(sum[i],2);
				else if(cha == 'T') sum[i] = (int) Math.pow(sum[i],3);
				
				if(cha == '*') {
					if(i==0) sum[i]*=2;
					else {
						sum[i]*=2;
						sum[i-1]*=2;
					}
				}else if(cha == '#') sum[i]*=-1;
			}
		}
		

//		System.out.println(str[0]);
//		System.out.println(str[1]);
//		System.out.println(str[2]);
//		System.out.println(sum[2]);
		
        return sum[0] + sum[1] + sum[2];
    }
	
	public static void main(String[] args) {
		
		String dartResult = "1D2S#10S";
		
		System.out.println(solution(dartResult));
		
		
	}
}
