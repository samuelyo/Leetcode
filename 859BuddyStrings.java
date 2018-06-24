package com.leetcode.BuddyStrings;

import java.util.ArrayList;
import java.util.List;

public class BuddyStrings {

	public static void main(String[] args) {

		String A = "";
		String B = "aa";
		boolean res = buddyStrings(A, B);
		System.out.println(res);

	}

	public static boolean buddyStrings(String A, String B) {

		if (A == null || B == null || A.length() != B.length()) {
			return false;
		}
		char[] chs1 = A.toCharArray();
		char[] chs2 = B.toCharArray();
		if (A.equals(B)) {
			int[] dp = new int[26];
			for (char ch : chs1) {
				dp[ch - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				if (dp[i] > 1) {
					return true;
				}
			}
			return false;
		} else {
			int len = chs1.length;
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < len; i++) {
				char ch1 = chs1[i];
				char ch2 = chs2[i];
				if (ch1 != ch2) {
					list.add(i);
				}
			}
			if (list.size() != 2) {
				return false;
			} else {
				int index1 = list.get(0);
				int index2 = list.get(1);
				return chs1[index1] == chs2[index2] && chs1[index2] == chs2[index1];
			}
		}

	}

}
