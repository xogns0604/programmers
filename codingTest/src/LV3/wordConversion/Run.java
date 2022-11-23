package LV3.wordConversion;

public class Run {

	public static void main(String[] args) {
		
		String begin = "hit";
		String target = "cog";
		
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(new Solution().solution(begin, target, words));
		
	}
}

