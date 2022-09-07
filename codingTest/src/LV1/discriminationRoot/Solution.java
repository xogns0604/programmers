package LV1.discriminationRoot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	public static int[] solution(int[] arr) {
		List<Integer> arrs = Arrays.stream(arr).boxed().collect(Collectors.toList());
		arrs.remove(Collections.min(arrs));
		
		if(arr.length == 1)return new int[]{-1};
        return arrs.stream().mapToInt(Integer::intValue).toArray();
    }
	
	public static int[] solution2(int[] arr) {
		if(arr.length == 1)return new int[]{-1};
		int min = Arrays.stream(arr).min().getAsInt();
		
		return Arrays.stream(arr).filter(num -> num != min).toArray();
    }
	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		
		System.out.println(Arrays.toString(solution(arr)));
	}
}
