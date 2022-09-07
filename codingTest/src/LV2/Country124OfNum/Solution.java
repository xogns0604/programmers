package LV2.Country124OfNum;

public class Solution {
	
	public String solution(int n) {
		
		String[] strs = {"4", "1", "2"};
		String str = "";
		
		while(n>0) {
			str += strs[n%3];
			if(n%3 == 0) n = (n/3) -1;
			else n = n/3;
		}
		
		
		return new StringBuilder(str).reverse().toString();
    }
	
	
}

/*
 * public void getStr(int n) { if(n==0) { return; }else {
 * 
 * for(int i=0; i<3; i++) { if(!check[i]) { check[i] = true; answer = cstr[i];
 * getStr(n--); } } } }
 */

/*
 * String[] strs = str.split("");
 * 
 * for(int i=strs.length-1 ; i>=0; i--) { if(strs[i].equals("0")) { strs[i] =
 * "4"; if(i!=0)strs[i-1] = String.valueOf(Integer.valueOf(strs[i-1]) -1); }
 * if(strs[i].equals("-1")) { strs[i] = "2"; if(i!=0) { strs[i-1] =
 * String.valueOf(Integer.valueOf(strs[i-1]) -1); } } }
 * 
 * if(strs[0] == "4") strs[0] = "";
 */