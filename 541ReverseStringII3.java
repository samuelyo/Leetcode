package com.leetcode.ReverseStringII;

public class ReverseStringII3 {

	public static void main(String[] args) {
		
		String s = "abcdefg";
		int k = 2;
		String res = reverseStr(s, k);
		System.out.println(res);

	}
	
	public static String reverseStr(String s, int k) {
		
		if(s.length() <= k) {
			return new StringBuilder(s).reverse().toString();
		}
		if(s.length() > k && s.length() < 2 * k) {
			String first = s.substring(0, k);
			String second = s.substring(k);
			return new StringBuilder(first).reverse().toString() + second;
		}
		String first = s.substring(0, k);
		String second = s.substring(k, 2 * k);
		String left = s.substring(2 * k);
		return new StringBuilder (first).reverse().toString() + second + reverseStr(left, k);
		
	}

}
