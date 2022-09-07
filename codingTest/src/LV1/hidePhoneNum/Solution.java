package LV1.hidePhoneNum;
//https://programmers.co.kr/learn/courses/30/lessons/12948

public class Solution {
	public String solution(String phone_number) {
        return phone_number.substring(0,phone_number.length()-4).replaceAll("[0-9]", "*") + phone_number.substring(phone_number.length()-4,phone_number.length());
    }
	
	
	public static void main(String[] args) {
	
	}
}
