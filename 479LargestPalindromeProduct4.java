package com.leetcode.LargestPalindromeProduct;

public class LargestPalindromeProduct4 {

	public static void main(String[] args) {
		
		int n = 2;
		System.out.println(largestPalindrome(n));

	}

	public static int largestPalindrome(int n) {
		
		if(n == 1) {
			return 9;
		}
		int max = (int) (Math.pow(10, n) - 1);
		for(int i = max;i > max/10;i--) {
			long cur = Long.valueOf(i + new StringBuilder().append(i).reverse().toString());
			for(long j = max;j * j >= cur;j--) {
				if(cur % j == 0) {
					return (int) (cur % 1337);
				}
			}
		}
		return 0;
		
	}
}
