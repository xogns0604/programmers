package divisorOfNumber;
//https://programmers.co.kr/learn/courses/30/lessons/77884

public class Solution {
	public int solution(int left, int right) {

		int answer = 0;
		
		for(int i=left ; i<=right ; i++) {
			int diviNum = 0;
			
			for(int j=1 ; j<=i ; j++) {
				if(i%j == 0) diviNum++;
			}
			
			if(diviNum%2 ==0) {
				answer+=i;
			}else {
				answer-=i;
			}
		}

        return answer;
    }
}
