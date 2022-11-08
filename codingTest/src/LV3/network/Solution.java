
package LV3.network;



public class Solution {
	
	int[][] computer;
	int answer = 0;
	
	public int solution(int n, int[][] computers) {
		
		int answer = 0;
		
		computer = computers;
		
		for(int i=0 ; i<n; i++) {
			if(computers[i][i] == 1) {
				move(i);
				answer++;
			}
		}
		
        return answer;
    }
	
	
	public void move(int com) {
		
		for(int i=0 ; i<computer.length ; i++) {
			if(computer[com][i] == 1) {
				computer[com][i] = 0;
				move(i);
			}
		}
	}

}



//첫번째 부터해서 링크로 잇고 0으로 삭제? Map에 중복없이 넣는것?
// 그냥 재귀함수를 사용하여 이어진 컴퓨터는 0으로 바꾸고 전체 탐색후에 넘어가는 식으로 설계
