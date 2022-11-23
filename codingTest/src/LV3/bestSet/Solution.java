
//https://school.programmers.co.kr/learn/courses/30/lessons/12938
package LV3.bestSet;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Solution {
	
	public int[] solution(int n, int s) {
		
		if(n>s) return new int[]{-1};
		
		//ArrayList<Integer> al = new ArrayList<Integer>();
		int[] answer = new int[n]; 
		
		for(int i=0 ; i<n ; i++) {
			int num = s/n;
			if(i>=n-s%n) {
				num++;
			}
			answer[i] = num;
		}
		
		return answer;
			
//        return al.stream().mapToInt(i -> i).toArray();
    }



}

//�������� ������ �ʿ��� ������ ��å�� ������ ������ �����غ��� �� ���ڰ��� ���̰� ������ ���� ũ��.
//������� 2, 9 �̸� 9/2�� ������ 4�� ������5�� ����ũ��.
//�ٸ��� 4/8 �̸� 2/2/2/2 �� ���� ���� ũ��
// �������� String�� List�� toArray()�� ����Ͽ� ��ȯ�Ҽ������� �⺻���� int�� �Ұ����ϴ�.
// for�� �Ἥ ������� ������ ���ϰ� stream�� ����Ͽ���.
// ȿ�����׽�Ʈ���� �����ߴ�.. stream�� ȿ������ ���� �������� ������ �迭�� �����ϰ� �־��ִ������� �ϴ°� �´°Ͱ���