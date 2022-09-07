//https://programmers.co.kr/learn/courses/30/lessons/1835

package LV2.GroupPhoto;

public class Solution {
	int answer = 0;
		System.out.println(new Solution().solution(1));
	
	public int solution(int n, String[] data) {
		boolean[] check = new boolean[8];
		String str = "";
		String[] kakaos = {"A", "C", "F", "J", "M", "N", "R", "T"};
		
		dfsMethod(check, str, kakaos, data);
		
        return answer;
    }
	
	//���̿켱Ž���Լ� ����Լ��� ����Ͽ� ����쿡 ���� Ž��
	public void dfsMethod(boolean[] check, String str, String[] kakaos, String[] data) {
		if(str.length()==8) {
			if(checkData(str, data)) answer++;
			return;
		}
		
		for(int i=0 ; i<8; i++) {
			if(!check[i]) {
				check[i] = true;
				String strs = str + kakaos[i];
				dfsMethod(check, strs, kakaos, data);
				check[i] = false;
			}
		}
	}
	
	public boolean checkData(String str, String[] data) {
		boolean result = true;
		
		for(String getData : data) {
			String[] toArr = getData.split("");
			
			int value1 = str.indexOf(toArr[0]);
			int value2 = str.indexOf(toArr[2]);

			int resultValue = Integer.valueOf(toArr[4]);
			
			
			switch(toArr[3]){
				case "=" : {
					if(Math.abs(value1 -value2) != (resultValue + 1)) {
						return false;
					}
					break;
				}
				case "<" : {
					if(Math.abs(value1 -value2) >= (resultValue + 1)) {
						return false;
					}
					break;
				}
				case ">" : {
					if(Math.abs(value1 -value2) <= (resultValue + 1)) {
						return false;
					}
					break;
				}
			}
			
		}
		
		return result;
	}
}

//���̿켱Ž��(dfs)Ȱ�� ���� ��� ��쿡 ���� ����Լ��� ȣ���Ͽ� Ž���ϰ� ������ �����ϴ� ��츦 ī����
//A, C, F, J, M, N, R, T
//"N~F=0", "R~T>2"