//https://programmers.co.kr/learn/courses/30/lessons/81301
package codingTest_numStringAlphabet;

//Integer Ŭ������ parseInt() �� valueOf()�� �������� 
//Autoboxing and Unboxing ���� ���ķ� ���̰� ����.
public class Solution {

	public static int solution(String s) {
		String str = s;
		
		str = str.replaceAll("zero", "0");
		str = str.replaceAll("one", "1");
		str = str.replaceAll("two", "2");
		str = str.replaceAll("three", "3");
		str = str.replaceAll("four", "4");
		str = str.replaceAll("five", "5");
		str = str.replaceAll("six", "6");
		str = str.replaceAll("seven", "7");
		str = str.replaceAll("eight", "8");
		str = str.replaceAll("nine", "9");
		

		int answer = Integer.valueOf(str);
		//System.out.println(a);
		
        return answer;
    }
	
	//�迭�� �̿��� ����� �ع�	
	public static int solution2(String s){
		String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0;i<strArr.length;i++){
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "one4seveneight";
		
		int h = solution(str);
		
		
	}

}
