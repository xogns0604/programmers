package failureRate;
//https://programmers.co.kr/learn/courses/30/lessons/42889
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static int[] solution(int N, int[] stages) {
        int[] clear = new int[N+1];
        int[] notClear = new int[N+1];
        
        for(int i : stages) {
        	notClear[i-1]+=1;
        	for(int j=0;j<i;j++) {
        		clear[j]+=1;
        	}
        }
        
        Map<Integer, Double> failure = new HashMap<Integer, Double>();
        double[] failureArr = new double[N];
        for(int i=0 ; i<N ; i++) {
        	double fail = (double)notClear[i]/clear[i];
        	if(clear[i] == 0) fail = 0;
        	failure.put(i+1, fail);
        	failureArr[i] = fail;
        }

        Arrays.sort(failureArr);
       
        System.out.println(Arrays.toString(failureArr));
        int[] answer = new int[N];
        int index = 0;
        for(int i=N-1; i>=0 ; i--) {
        	for(int j=1 ; j<=N; j++) {
        		if(failureArr[i] == failure.get(j)) {
        			answer[index++] = j;
        			failure.put(j, -1.0);
        		}
        	}
        }
      
       
        return answer;
    }
	
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		System.out.println(Arrays.toString(solution(N,stages)));
		
		
	}
}
