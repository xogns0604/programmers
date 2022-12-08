
package LV3.wordConversion;



public class Solution {
	
	private boolean[] checked;
	private int answer = 0; 
	private String targetStr;
	
	public int solution(String begin, String target, String[] words) {
		
		checked = new boolean[words.length];
		targetStr = target;
		
		dfs(begin, words, 0);

        return answer;
    }
	
	private void dfs(String begin, String[] words, int count) {
		if(begin.equals(targetStr)) {
			answer = count;
			return;
		}
		
		for(int i=0 ; i<words.length ; i++) {
			if(checked[i]) continue;
			
			int check = 0;
			for(int j=0 ; j<begin.length() ; j++) {
				if(begin.charAt(j) != words[i].charAt(j)) {
					check++;
				}
			}
			
			if(check == 1) {
				checked[i] = true;
				dfs(words[i], words, count++);
				checked[i] = false;
			}
		}
	}
	
	

}


//ó���� �پ��� ������ ������ ������ ������ ���� �ϼ��Ǵ� ���̽��� ���� ������ �����ߴ�
// ������ �ּҰ��� ���ϴ� �����̴� �ݺ��� �ȴٸ� �ּҰ��� ������ �ʰų� �ϼ����� ���������� ������ 1�ܾ�� 1���ۿ� �����ٰ� �����ϰ� �ڵ��� ����
//������ ��Ʈ��� DFS�� ����ϱ�� ����