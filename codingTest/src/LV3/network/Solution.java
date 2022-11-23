
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



//ù��° �����ؼ� ��ũ�� �հ� 0���� ����? Map�� �ߺ����� �ִ°�?
// �׳� ����Լ��� ����Ͽ� �̾��� ��ǻ�ʹ� 0���� �ٲٰ� ��ü Ž���Ŀ� �Ѿ�� ������ ����