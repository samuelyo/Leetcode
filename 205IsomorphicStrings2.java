package com.leetcode.IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings2 {

	public static void main(String[] args) {

		String s = "paper";
		String t = "title";
		System.out.println(isIsomorphic(s, t));

	}

	public static boolean isIsomorphic(String s, String t) {

		int[] m1 = new int[256];
		int[] m2 = new int[256];
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (m1[s.charAt(i)] != m2[t.charAt(i)])
				return false;
			m1[s.charAt(i)] = i + 1;
			m2[t.charAt(i)] = i + 1;
		}
		return true;

	}
}
