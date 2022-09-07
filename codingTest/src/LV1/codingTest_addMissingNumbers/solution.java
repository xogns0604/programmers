package codingTest_addMissingNumbers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//https://programmers.co.kr/learn/courses/30/lessons/86051

public class solution {

	public static int solution(int[] numbers) {
		Set<Integer> numSet = new HashSet<Integer>();
		
		for(int i=0;i<10;i++) numSet.add(i);
		
		for(int i : numbers) {
			numSet.remove(i);
		}
		
		Iterator<Integer> it = numSet.iterator();
		
		int answer = 0;
		while(it.hasNext()) {
			answer += it.next();
		}
		
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] numbers = {1,2,3,4,6,7,8,0};
		int[] numbers = {5,8,4,0,6,7,9};
		
		int num = solution(numbers);

		System.out.println(num);

	}

}
