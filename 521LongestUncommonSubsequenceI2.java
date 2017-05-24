package com.leetcode.LongestUncommonSubsequenceI;

public class LongestUncommonSubsequenceI2 {

	public static void main(String[] args) {
		
		String a = "aba";
		String b = "cdc";
		System.out.println(findLUSlength(a, b));

	}
	
	public static int findLUSlength(String a, String b) {
		
		return a.equals(b) ? -1 : Math.max(a.length(), b.length());
	}

}
