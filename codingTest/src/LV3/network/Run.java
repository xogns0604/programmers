package LV3.network;

public class Run {

	public static void main(String[] args) {
		
		int n = 3;
		int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
		
		System.out.println(new Solution().solution(n, computers));
	}
}

