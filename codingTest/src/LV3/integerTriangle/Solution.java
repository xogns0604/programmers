
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
		 
		 
	
	
	
	
	
	
	/* ���� ����Լ��� DFS������ �ڵ�
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


// for������ ���� DFS(���� Ž���˰���)�� ���� ���
// �ð��ʰ� ���� �߻� -> DP(������ȹ��)�� ���� ��Ʈ
// DP �ڷ�
// https://hongjw1938.tistory.com/47
// ���� �κп��� ���ʿ��� ���� �߰�
//     7
//   3   8
// 8   1   0
// �Ʒ��� �� ���ڵ��� ���ذ��� ��ġ�� �κ��� ���ʿ� �� ū���ڸ� ���������� ����