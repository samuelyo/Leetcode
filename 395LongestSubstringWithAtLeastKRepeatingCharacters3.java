package com.leetcode.LongestSubstringWithAtLeastKRepeatingCharacters;

public class LongestSubstringWithAtLeastKRepeatingCharacters3 {

	public static void main(String[] args) {
		
		String s = "ababacb";
		int k = 3;
		System.out.println(longestSubstring(s, k));

	}
	
	public static int longestSubstring(String s, int k) {
		
		return longestSubstringHelp(s, k, 0, s.length());
		
	}
	
	public static int longestSubstringHelp(String s, int k, int start, int end) {
		
		if(end - start < k) {
			return 0;
		}
		int[] dp = new int[26];
		for(int i = start;i<end;i++) {
			char cur = s.charAt(i);
			dp[cur - 'a'] ++;
		}
		for(int i = 0;i<26;i++) {
			int times = dp[i];
			if(times > 0 && times < k) {
				char cur = (char) ('a' + i);
				for(int j = start;j<end;j++) {
					if(cur == s.charAt(j)) {
						int left = longestSubstringHelp(s, k, start, j);
						int right = longestSubstringHelp(s, k, j + 1, end);
						return Math.max(left, right);
					}
				}
			}
		}
		return end - start;
	}

}
