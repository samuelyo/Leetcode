package com.leetcode.IsSubsequence;

public class IsSubsequence3 {

	public static void main(String[] args) {
		
		String s = "";
		String t = "axc";
		System.out.println(isSubsequence(s, t));
		
	}

	public static boolean isSubsequence(String s, String t) {
		
		Integer start = -1;
		for(int i = 0;i<s.length();i++) {
			boolean temp = false;
			int index = start + 1;
			while(index < t.length()) {
				if(t.charAt(index) == s.charAt(i)) {
					temp = true;
					start = index;
					break;
				}
				index ++;
			}
			if(!temp) {
				return false;
			}
		}
		return start <= t.length();
		
	}
}
