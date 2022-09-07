package innerProduct;

import java.util.stream.IntStream;

//https://programmers.co.kr/learn/courses/30/lessons/76501

public class Solution {
	
	public static int solution(int[] a, int[] b) {
		int answer = 0;
		for(int i=0;i<a.length;i++) {
			answer+=(a[i] * b[i]);
		}
        return answer;
    }
	
	public static int solution2(int[] a, int[] b) {
		return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		
		System.out.println(solution2(a,b));
	}
}
