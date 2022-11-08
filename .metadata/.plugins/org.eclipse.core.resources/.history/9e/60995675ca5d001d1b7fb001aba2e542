
//https://programmers.co.kr/learn/courses/30/lessons/43165
package LV3.integerTriangle;

import java.util.Arrays;

public class Solution {
	
	
	
	public int solution(int[][] triangle) {
		
		for(int i=1 ; i<triangle.length ; i++) {
			for(int j=0 ; j<triangle[i].length ; j++) {
				if(j == 0) {
					triangle[i][j] += triangle[i-1][j]; 
				} else if(j == triangle[i].length-1) {
					triangle[i][j] += triangle[i-1][j-1]; 
				} else {
					triangle[i][j] += (triangle[i-1][j] > triangle[i-1][j-1] ? triangle[i-1][j] : triangle[i-1][j-1]);
				}
			}
		}
		
		Arrays.sort(triangle[triangle.length-1]);

		return triangle[triangle.length-1][triangle[triangle.length-1].length-1];
    }
		 
		 
	
	
	
	
	
	
	/* 최초 재귀함수로 DFS구현한 코드
	 * void triangleMethod(int sum, int depth, int width) {
	 * 
	 * if(depth == triangleOut.length) { if(num < sum) num = sum; return; }
	 * 
	 * 
	 * for(int i=width ; i<=width+1 ; i++) { if(depth == 0 && i == 1)return;
	 * triangleMethod(sum + triangleOut[depth][i], depth + 1, i); }
	 * 
	 * }
	 */

}


// for문으로 할지 DFS(깊이 탐색알고리즘)을 쓸지 고민
// 시간초과 오류 발생 -> DP(동적계획법)에 대한 힌트
// DP 자료
// https://hongjw1938.tistory.com/47
// 많은 부분에서 불필요한 연산 발견
//     7
//   3   8
// 8   1   0
// 아래로 각 숫자들을 더해가고 겹치는 부분은 위쪽에 더 큰숫자를 가져오도록 설계