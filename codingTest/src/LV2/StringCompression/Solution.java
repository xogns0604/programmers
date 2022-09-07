package LV2.StringCompression;
//https://programmers.co.kr/learn/courses/30/lessons/60057

import java.util.Stack;

public class Solution {
	public static int solution(String s) {
		
		Stack<String> strs = new Stack<String>();
		
		int answer = 1000;
		
		//1���� ���ڿ��� �������� �ݺ�
		for(int i=1 ; i<=s.length() ; i++) {
			String result = "";
			
			//���ڿ��� ������ ��ȯ�ϴ� �۾�
			for(int j=0 ; j<s.length() ; j+=i) {
				String str;
				if(j+i>s.length()) str = s.substring(j,s.length());
				else str = s.substring(j,j+i);
				
				//������ ��������� �ְ� �ƴϸ� ���Ͽ� ���ڿ��� ����� ����
				if(strs.isEmpty())strs.push(str);
				else {
					String strpop = strs.pop();

					//���ÿ� �ִ� ���ڿ� ������ �������� �װ� �ƴϸ� pop�Ͽ� ���ڿ��� �߰��ϰ� ���ο� ���ڸ� push
					if(strpop.equals(str)) {
						if(strs.isEmpty()) {
							strs.push("2");
							strs.push(strpop);
						}else {
							String strInt = strs.pop();
							strs.push(String.valueOf(Integer.valueOf(strInt) + 1));
							strs.push(strpop);
						}
					}else {
						String resultStack = "";
						resultStack+=strpop;
						if(!strs.isEmpty())resultStack = strs.pop() + resultStack;
						
						result+=resultStack;
						strs.push(str);
					}
				}
			}
			
			//������ �ܰ迡 ���� ���ڿ��� ������ pop�Ͽ� ���ڿ��� ����
			if(!strs.isEmpty()) {
				String resultStack = strs.pop();
				if(!strs.isEmpty()) resultStack = strs.pop() + resultStack;
				
				result+=resultStack;
			}
			
			
			answer = Math.min(answer, result.length());
		}

        
        return answer;
    }
	
	
	public static void main(String[] args) {
		System.out.println(solution("ababcdcdababcdcd"));
	}
}


