package LV1.TestPersonalityType;

public class Run {

	public static void main(String[] args) {
		
//		String[] survey = {"TR", "RT", "TR"};
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
//		int[] choices = {7, 1, 3};

		int[] choices = {5, 3, 2, 7, 5};
		
		System.out.println(new Solution().solution(survey, choices));
	}

}
