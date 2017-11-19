package com.leetcode.ReverseString;

public class ReverseString5 {

	public static void main(String[] args) {
		
		String s = "hello";
		String res = reverseString(s);
		System.out.println(res);

	}

	public static String reverseString(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
		
	}

}
