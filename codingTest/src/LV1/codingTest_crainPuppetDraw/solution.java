//https://programmers.co.kr/learn/courses/30/lessons/64061

package LV1.codingTest_crainPuppetDraw;

import java.util.Stack;

public class solution {
	
	public static int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		int answer = 0;

		for(int i=0;i<moves.length;i++) {	
			int puppet = 0;
			int crainPick = moves[i]-1;
			
			for(int j=0;j<board.length;j++) {
				if(board[j][crainPick] != 0) {
					puppet = board[j][crainPick];
					board[j][crainPick] = 0;
					break;
				}
			}
			
			if(!stack.empty()) {
				if(stack.peek() == puppet) {
					stack.pop();
					answer+=2;
					continue;
				}
			}
			
			if(puppet != 0) stack.add(puppet);
		}
		
        return answer;
    }
	
	public static void crain(int[][] board) {
		for(int i=0; i<board.length;i++) {
			for(int j=0; j<board[i].length;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void getStack(Stack sta) {
		System.out.println("-------stack");
		for(int i=sta.size()-1; i>=0;i--) {
			System.out.println(sta.elementAt(i));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
	
		
		int answer = solution(board, moves);
		System.out.println(answer);
		
	
	}

	
}
