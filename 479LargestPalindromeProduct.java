package com.leetcode.LargestPalindromeProduct;

public class LargestPalindromeProduct {

	public static void main(String[] args) {
		
		int n = 2;
		System.out.println(largestPalindrome(n));

	}

	public static int largestPalindrome(int n) {
		
		if(n == 1){
			return 9;
		}
		int high = (int) (Math.pow(10, n) - 1);
		int low = (int) Math.pow(10, n-1);
		for(int i = high;i>=low;i--){
			long cur = createPalindrome(i);
			for(int j = high;j>=low;j--){
				if(cur / j > high){
					break;
				}
				if(cur % j == 0){
					return (int) (cur % 1337);
				}
			}
		}
		return -1;
		
	}
	
	public static long createPalindrome(int n) {
		
		String curString = Integer.toString(n);
		return Long.valueOf(curString + new StringBuilder(curString).reverse().toString());
		
	}
}
