//https://programmers.co.kr/learn/courses/30/lessons/92334

package codingTest_Get_report_results;

import java.util.*;

public class solution {
	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] reportedP = new int[answer.length];
        for(int i=0;i<answer.length;i++) {
        	answer[i] = 0;
        	reportedP[i] = 0;
        }
        
        Set<String> set = new HashSet<String>(Arrays.asList(report));
        List<String> list = new ArrayList<String>(set);
        
        String[] delreport = list.toArray(new String[list.size()]);
        String[][] reports = new String[2][delreport.length+1];
        
        for(int i=0;i<delreport.length;i++) {
        	StringTokenizer str = new StringTokenizer(delreport[i], " ");
        	reports[0][i] = str.nextToken();
        	reports[1][i] = str.nextToken();
        	
        	for(int j=0;j<id_list.length;j++) {
        		if(id_list[j].equals(reports[1][i])) {
        			reportedP[j]++;
        		}
        	}
        }
      
        for(int i=0;i<answer.length;i++) {
        	if(reportedP[i]>=k) {
        		String reported = id_list[i];
        		
        		for(int j=0;j<delreport.length;j++) {
        			if(reports[1][j].equals(reported)) {
        				String repoter = reports[0][j];
        				
        				for(int q=0;q<id_list.length;q++) {
        					if(repoter.equals(id_list[q])) {
        						answer[q]++;
        					}
        				}
        			}
        		}
        	}
        }

        return answer;
    }
	
	public static void main(String[] args) {
		String id_list[] = {"muzi", "frodo", "apeach", "neo"};
		String report[] = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		
		int[] answer = solution(id_list,report,2);
		
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}

	}
}
