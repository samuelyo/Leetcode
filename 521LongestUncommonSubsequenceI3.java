package com.leetcode.LongestUncommonSubsequenceI;

public class LongestUncommonSubsequenceI3 {

	public static void main(String[] args) {
		
		String a = "aba";
		String b = "cdc";
		int res = findLUSlength(a, b);
		System.out.println(res);
		
	}

	public static int findLUSlength(String a, String b) {
		
		if(a.equals(b)) {
			return -1;
		}else {
			return Math.max(a.length(), b.length());
		}
		
	}
}
