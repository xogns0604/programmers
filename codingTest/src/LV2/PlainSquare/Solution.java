//https://programmers.co.kr/learn/courses/30/lessons/62048
package LV2.PlainSquare;

import java.math.BigInteger;

public class Solution {
	public long solution(int w, int h) {
		long wL = Long.valueOf(w);
		long hL = Long.valueOf(h);
        return wL*hL - (wL+hL-method(wL, hL));
    }
	
	//최대공약수 구하는 메서드
	public long method(long w, long h) {
		long num = 1;
		
		for(long i=2 ; i<=Math.min(w, h) ; i++) {
			if(w%i == 0 && h%i == 0) num=i;
		}

		return num;
	}
}

//double slope = (double)h/w;
//long answer = Long.valueOf(w)*Long.valueOf(h);
//
//for(int i=1 ; i<=w ; i++) {
//	int y = (int) (Math.ceil(slope * i));
//	int yDown = (int) (Math.floor(slope * (i-1)));
//	
//	
//	for(int j=0 ; j<y-yDown ; j++) answer--;
//}
//for(double j = Math.floor(slope * (i-1)) ; j<Math.ceil(slope * i) ; j++) {
//answer--;
//}
//int y = (int) (Math.ceil(slope * i));
//int yDown = (int) (Math.ceil(slope * (i-1)));
//
//System.out.println(yDown);
//System.out.println(y);
//
//for(int j = yDown ; j<=y ; j++) {
//	answer--;
//}
//System.out.println(answer);
//System.out.println();
//System.out.println(y);
//System.out.println(yDown);
//System.out.println();
//0
//2
//2
//3
//3
//5
//5
//6
//6
//8
//8
//9
//9
//11
//11
//12

//0
//2
//1
//3
//3
//5
//4
//6
//6
//8
//7
//9
//9
//11
//10
//12