package com.leetcode.ValidAnagram;

public class ValidAnagram4 {

	public static void main(String[] args) {
		
		String s = "rat";
		String t = "cat";
		System.out.println(isAnagram(s, t));
		

	}

	public static boolean isAnagram(String s, String t) {
		
		int[] times = new int[26];
		for(int i = 0;i<s.length();i++) {
			char cur = s.charAt(i);
			times[cur - 'a'] ++;
		}
		for(int i = 0;i<t.length();i++) {
			char cur = t.charAt(i);
			if(times[cur - 'a'] <= 0) {
				return false;
			}
			times[cur - 'a'] --;
		}
		for(int i = 0;i<26;i++) {
			if(times[i] != 0) {
				return false;
			}
		}
		return true;
		
	}
}
