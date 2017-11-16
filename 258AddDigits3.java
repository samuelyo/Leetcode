package com.leetcode.AddDigits;

public class AddDigits3 {

	public static void main(String[] args) {
		
		int num = 38;
		int res = addDigits(num);
		System.out.println(res);

	}
	
	public static int addDigits(int num) {
		
		String numString = String.valueOf(num);
		while(numString.length() != 1) {
			int sum = 0;
			for(int i = 0;i<numString.length();i++) {
				sum += numString.charAt(i) - '0';
			}
			numString = String.valueOf(sum);
		}
		return Integer.valueOf(numString);
		
	}

}
