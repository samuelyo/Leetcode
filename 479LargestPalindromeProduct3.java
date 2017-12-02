package com.leetcode.LargestPalindromeProduct;

public class LargestPalindromeProduct3 {

	public static void main(String[] args) {
		
		int n = 2;
		System.out.println(largestPalindrome(n));

	}

	public static int largestPalindrome(int n) {
		
		if(n == 1) {
			return 9;
		}
		int high = (int) (Math.pow(10, n) - 1);
		int low = (int) Math.pow(10, n - 1);
		
		for(int i = high;i>=low;i--) {
			long product = createPalindrome(i);
			for(int j = high;j>=low;j--) {
				if(product / j > high) {
					break;
				}
				if(product % j == 0) {
					return (int) (product % 1337);
				}
			}
		}
		return 0;
		
	}
	
	public static long createPalindrome(int i) {
		
		String value = Integer.toString(i);
		String res = value + new StringBuilder(value).reverse().toString();
		return Long.valueOf(res);
	}
}
