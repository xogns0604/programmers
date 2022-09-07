package primeNumber;

import java.util.Arrays;

public class Solution {
	public static int solution(int[] nums) {
		Arrays.sort(nums);
		int answer = 0;
		
		for(int i=0;i<nums.length-2;i++) {
			for(int j=i+1;j<nums.length-1;j++) {
				for(int k=j+1;k<nums.length;k++) {
					int sum = nums[i] + nums[j] + nums[k];
					
					boolean prime = true;
					for(int l=2 ; l<sum ; l++) {
						if(sum%l == 0) prime = false;
					}
					
					if(prime) {
						System.out.printf("[%d,%d,%d]를 이용해서 %d을 만들 수 있습니다." , nums[i], nums[j], nums[k], (nums[i] + nums[j] + nums[k]));
						System.out.println();
						answer++;
					}
				}
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,7,6,4,888,999,245,123,484};
		
		System.out.println(solution(nums));
	}
}
