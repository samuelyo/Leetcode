package com.leetcode.AddStrings;

public class AddStrings3 {

	public static void main(String[] args) {
		
		String num1 = "99";
		String num2 = "99";
		String res = addStrings(num1, num2);
		System.out.println(res);

	}
	
	public static String addStrings(String num1, String num2) {
		
		int index = 0;
		int extra = 0;
		StringBuilder res = new StringBuilder();
		while(index < num1.length() || index < num2.length()) {
			int ch1 ;
			if(index < num1.length()) {
				ch1 = num1.charAt(num1.length() - 1 - index) - '0';
			}else {
				ch1 = 0;
			}
			int ch2 ;
			if(index < num2.length()) {
				ch2 = num2.charAt(num2.length() - 1 - index) - '0';
			}else {
				ch2 = 0;
			}
			int sum = ch1 + ch2 + extra;
			res.insert(0, sum % 10);
			extra = sum / 10;
			index ++;
		}
		if(extra != 0) {
			res.insert(0, extra);
		}
		return res.toString();
		
	}

}
