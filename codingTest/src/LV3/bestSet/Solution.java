
//https://school.programmers.co.kr/learn/courses/30/lessons/12938
package LV3.bestSet;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Solution {
	
	public int[] solution(int n, int s) {
		
		if(n>s) return new int[]{-1};
		
		//ArrayList<Integer> al = new ArrayList<Integer>();
		int[] answer = new int[n]; 
		
		for(int i=0 ; i<n ; i++) {
			int num = s/n;
			if(i>=n-s%n) {
				num++;
			}
			answer[i] = num;
		}
		
		return answer;
			
//        return al.stream().mapToInt(i -> i).toArray();
    }



}

//수학적인 지식이 필요한 문제라서 공책에 빼곡히 패턴을 연구해보니 각 숫자간의 차이가 적을때 가장 크다.
//예를들어 2, 9 이면 9/2의 버림인 4와 나머지5가 가장크다.
//다르게 4/8 이면 2/2/2/2 의 곱이 가장 크다
// 참조형인 String은 List를 toArray()를 사용하여 변환할수있지만 기본형인 int는 불가능하다.
// for을 써서 만들수도 있지만 편하게 stream을 사용하였다.
// 효율성테스트에서 실패했다.. stream이 효율성이 많이 떨어지기 때문에 배열을 선언하고 넣어주는쪽으로 하는게 맞는것같다