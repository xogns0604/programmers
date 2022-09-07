package ponketmon;
//https://programmers.co.kr/learn/courses/30/lessons/1845
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
	public static int solution(int[] nums) {
		Set numSet = new HashSet();
		
		for(int i : nums) numSet.add(i);

        int answer = numSet.size();

        if(answer > nums.length/2) answer = nums.length/2;
        return answer;
    }
	
	public static int solution2(int[] nums) {
		return Arrays.stream(nums).boxed().
				collect(Collectors.
				collectingAndThen(Collectors.toSet(),pk -> Integer.min(pk.size(),nums.length/2)));
	}
	
	public static void main(String[] args) {
		int[] nums = {3,1,2,3};
		
		System.out.println(solution(nums));
	}
}
