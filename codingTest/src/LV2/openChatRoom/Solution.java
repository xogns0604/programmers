//https://programmers.co.kr/learn/courses/30/lessons/42888
package LV2.openChatRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static String[] solution(String[] record) {
		List<String[]> reList = new ArrayList<String[]>();
		
		for(String str : record) reList.add(str.split(" "));
		
		Map<String, String> ids = new HashMap<String, String>();
		
		int index =0;
		for(int i=0 ; i<reList.size() ; i++) {
			if(reList.get(i).length ==3) ids.put(reList.get(i)[1], reList.get(i)[2]);
			if(!reList.get(i)[0].equals("Change")) index++;
		}
		
		
		String[] answer = new String[index];
		
		System.out.println(index);
		index=0;
		for(String[] strs : reList) {
			String str = ids.get(strs[1]);
			str+="님이 ";
			
			if(strs[0].equals("Enter")) {
				str+="들어왔습니다.";
				answer[index++] = str;
			}else if(strs[0].equals("Leave")) {
				str+="나갔습니다.";
				answer[index++] = str;
			}
			
			
		}
		
        return answer;
    }
    
    public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan", "Enter uid4567 Prodo" ,"Change uid4567 Ryan", "Leave uid1234","Leave uid1234"};
    	
    	System.out.println(Arrays.toString(solution(record)));
	}
}
/*
for(int i=0 ; i<reList.size() ; i++) {
	if(reList.get(i).length != 2) {
		for(int j=0 ; j<i ; j++) {
			if(reList.get(i)[1].equals(reList.get(j)[1]) && reList.get(j).length == 3) {
				reList.get(j)[2] = reList.get(i)[2];
			}
		}
	}
}

String[] answer = new String[record.length];
for(int i=0 ; i<reList.size() ; i++) {
	answer[i] = String.join("", reList.get(i));
	System.out.println(answer[i]);
}
*/