package com.leetcode.BaseSeven;

public class BaseSeven3 {

	public static void main(String[] args) {
		
		int num = -7;
		String res = convertToBase7(num);
		System.out.println(res);

	}
	
	public static String convertToBase7(int num) {
        
		boolean neg = false;
		if(num < 0) {
			neg = true;
			num = -num;
		}
		if(num == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		while(num != 0) {
			int temp = num % 7;
			sb.append(temp);
			num /= 7;
		}
		sb = sb.reverse();
		if(neg) {
			return "-" + sb.toString();
		}else {
			return sb.toString();
		}
    }

}
