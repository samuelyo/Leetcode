package com.leetcode.IsSubsequence;

public class IsSubsequence {

	public static void main(String[] args) {
		
		String s = "aac";
		String t = "ab";
		
		System.out.println(isSubsequence(s, t));

	}
	
	public static boolean isSubsequence(String s, String t) {
		
		int sIndex = 0;
		int tIndex = 0;
		while(sIndex < s.length()){
			while(tIndex < t.length() && s.charAt(sIndex) != t.charAt(tIndex)){
				tIndex ++;
			}
			if(tIndex == t.length()){
				return false;
			}
			sIndex ++;
			tIndex ++;
		}
		return true;
		
	}

}
