package com.leetcode.PalindromePartitioningII;

public class PalindromePartitioningII3 {

	public static void main(String[] args) {

		String s = "aab";
		System.out.println(minCut(s));

	}

	public static int minCut(String s) {

		int len = s.length();
		int[] cut = new int[len + 1];
		for(int i = 0;i<=len;i++) {
			cut[i] = i - 1;
		}
		for(int i = 0;i<len;i++) {
			for(int j = 0;i - j >= 0 && i + j < len && s.charAt(i - j) == s.charAt(i + j);j++) {
				cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j]);
			}
			for(int j = 1;i - j + 1 >= 0 && i + j < len && s.charAt(i - j + 1) == s.charAt(i + j); j++) {
				cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
			}
		}
		return cut[len];

	}
}
