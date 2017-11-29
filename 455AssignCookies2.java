package com.leetcode.AssignCookies;

import java.util.Arrays;

public class AssignCookies2 {

	public static void main(String[] args) {

		int[] g = { 1, 2, 3, 2, 3 };
		int[] s = { 1, 4, 2, 3 };
		System.out.println(findContentChildren(g, s));

	}

	public static int findContentChildren(int[] g, int[] s) {

		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0;
		for (int j = 0; i < g.length && j < s.length; j++) {
			if (g[i] <= s[j])
				i++;
		}
		return i;

	}

}
