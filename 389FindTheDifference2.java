package com.leetcode.findthedifference;

import java.util.Arrays;

public class FindTheDifference2 {

	public static void main(String[] args) {
		
		String s = "abcd";
		String t = "eabcd";
		System.out.println(findTheDifference(s, t));

	}
	
	public static char findTheDifference(String s,String t){
		
		char c = 0;
		for (int i = 0; i < s.length(); ++i) {
			c ^= s.charAt(i);
			c ^= t.charAt(i);
		}
		c ^= t.charAt(t.length()-1);
		return c;

	}

}
