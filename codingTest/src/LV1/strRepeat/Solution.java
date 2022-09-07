package LV1.strRepeat;

public class Solution {
	public static String solution(int n) {
		
		StringBuilder sb = new StringBuilder();
		
		while(n!=0) {
			sb.append("��");
			n--;
			if(n==0)break;
			sb.append("��");
			n--;
		}
        return sb.toString();
    }
	
	public static String solution2(int n) {
		return new String(new char[n/2+1]).replace("\0", "����").substring(0,n);
	}
	
	public static void main(String[] args) {
		System.out.println(solution2(4));
		
		char[] ch = new char[2];
		
		String str = new String(ch);
		
		str+="11";
		System.out.println(str);
		str = str.replace("\0", "����");
		System.out.println(str);
		
	}
}
