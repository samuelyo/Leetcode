package com.leetcode.FindTheDifference;

public class FindTheDifference3 {

	public static void main(String[] args) {
		
		String s = "abcbd";
		String t = "abbecd";
		System.out.println(findTheDifference(s, t));

	}

	public static char findTheDifference(String s, String t) {
		
		int[] times = new int[26];
		for(int i = 0;i<s.length();i++) {
			times[s.charAt(i) - 'a'] ++;
		}
		for(int i = 0;i<t.length();i++) {
			times[t.charAt(i) - 'a'] --;
			if(times[t.charAt(i) - 'a'] < 0) {
				return t.charAt(i);
			}
		}
		return 'a';
		
	}
}
