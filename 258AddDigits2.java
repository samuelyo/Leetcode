package com.leetcode.AddDigits;

public class AddDigits2 {

	public static void main(String[] args) {
		
		int num = 99;
		System.out.println(addDigits(num));

	}
	
	public static int addDigits(int num) {
		
		return 1 + (num - 1) % 9;
	}

}
