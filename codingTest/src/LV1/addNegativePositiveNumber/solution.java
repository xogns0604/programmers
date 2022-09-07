package addNegativePositiveNumber;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class solution {

	public static int solution(int[] absolutes, boolean[] signs) {
        
		int answer = 0;
		for(int i=0;i<absolutes.length;i++) {
			if(signs[i]) answer+=absolutes[i];
			else answer-=absolutes[i];
		}
		
        return answer;
    }
	
	
	public static int solution2(int[] absolutes, boolean[] signs) {
		AtomicInteger index = new AtomicInteger();
		
        return Arrays.stream(absolutes).reduce(0,(a,b) ->{
			index.getAndIncrement();
			return signs[index.get() - 1] ? a+b : a-b;
		});
    }
	
	public static int solution3(int[] absolutes, boolean[] signs) {

		return IntStream.range(0,absolutes.length).map(index -> signs[index] ? absolutes[index] : -absolutes[index]).sum();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		
		System.out.println(solution3(absolutes, signs));
	}

}
