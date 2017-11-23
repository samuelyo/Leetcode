package com.leetcode.FirstUniqueCharacterInAString;

public class FirstUniqueCharacterInAString3 {

	public static void main(String[] args) {
		
		String s = "loveleetcode";
		int res = firstUniqChar(s);
		System.out.println(res);

	}
	
	public static int firstUniqChar(String s) {
		
		int[] times = new int[26];
		for(int i = 0;i<s.length();i++) {
			times[s.charAt(i) - 'a'] ++;
		}
		for(int i = 0;i<s.length();i++) {
			if(times[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
		
	}

}
