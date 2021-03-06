package com.leetcode.PalindromeNumber;

public class PalindromeNumber2 {

	public static void main(String[] args) {

		// System.out.println(Math.pow(10, 2));
		System.out.println(isPalindrome(10000001));

	}

	public static boolean isPalindrome(int x) {

		//compare half of the digits in x
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;
		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return (x == rev || x == rev / 10);

	}

}
