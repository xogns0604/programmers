package LV1.ColatzConjecture;

public class Solution {
	public static int solution(int num) {
		int i=0;
		long n = num;
		
		while(true) {
			if(i==500)return -1;
			if(n==1)return i;
			n = ((n%2 == 0) ? n/2 : n*3+1);
			i++;
		}    
    }
	
	public static void main(String[] args) {
		System.out.println(solution(626331));
	}
}
