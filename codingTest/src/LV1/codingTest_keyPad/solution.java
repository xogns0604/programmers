//https://programmers.co.kr/learn/courses/30/lessons/67256

package codingTest_keyPad;

public class solution {

	public static String solution(int[] numbers, String hand) {
		
		String answer = "";
		
		int[] leftLocaton = {3,0};
		int[] rightLocaton = {3,2};
		
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
				answer+="L";
				if(numbers[i]==1) leftLocaton = new int[]{0,0};
				else if(numbers[i]==4) leftLocaton = new int[]{1,0};
				else leftLocaton = new int[]{2,0};
				continue;
			}
			
			if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) {
				answer+="R";
				if(numbers[i]==3) rightLocaton = new int[]{0,2};
				else if(numbers[i]==6) rightLocaton = new int[]{1,2};
				else rightLocaton = new int[]{2,2};
				continue;
			}
			
			int[] selectLocation = null;
			if(numbers[i]==2) selectLocation = new int[]{0,1};
			else if(numbers[i]==5) selectLocation = new int[]{1,1};
			else if(numbers[i]==8) selectLocation = new int[]{2,1};
			else selectLocation = new int[] {3,1};
			
			int leftL = Math.abs(leftLocaton[0]-selectLocation[0]) + Math.abs(leftLocaton[1]-selectLocation[1]);
			int rightL = Math.abs(rightLocaton[0]-selectLocation[0]) + Math.abs(rightLocaton[1]-selectLocation[1]);

			if(leftL<rightL) {
				answer+="L";
				leftLocaton = selectLocation;
			}else if(leftL>rightL) {
				answer+="R";
				rightLocaton = selectLocation;
			}else {
				if(hand.equals("left")) {
					answer+="L";
					leftLocaton = selectLocation;
				}else {
					answer+="R";
					rightLocaton = selectLocation;
				}
			}
		}
		
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		String answer = solution(numbers, hand);
		
		System.out.println(answer);
		
		
		
	}

}
