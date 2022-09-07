package LV2.StringCompression;
//https://programmers.co.kr/learn/courses/30/lessons/60057

import java.util.Stack;

public class Solution {
	public static int solution(String s) {
		
		Stack<String> strs = new Stack<String>();
		
		int answer = 1000;
		
		//1부터 문자열의 갯수까지 반복
		for(int i=1 ; i<=s.length() ; i++) {
			String result = "";
			
			//문자열을 나누고 변환하는 작업
			for(int j=0 ; j<s.length() ; j+=i) {
				String str;
				if(j+i>s.length()) str = s.substring(j,s.length());
				else str = s.substring(j,j+i);
				
				//스택이 비어있으면 넣고 아니면 비교하여 문자열을 만드는 과정
				if(strs.isEmpty())strs.push(str);
				else {
					String strpop = strs.pop();

					//스택에 있는 문자와 같으면 증가시켜 쌓고 아니면 pop하여 문자열에 추가하고 새로운 문자를 push
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
			
			//마무리 단계에 남은 문자열이 있으면 pop하여 문자열에 더함
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


