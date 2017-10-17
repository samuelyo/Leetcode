package com.leetcode.WildcardMatching;

public class WildcardMatching3 {

	public static void main(String[] args) {

		String s = "aab";
		String p = "c*a*b";
		System.out.println(isMatch(s, p));

	}

	public static boolean isMatch(String s, String p) {

		if (s == null || p == null)
			return false;
		int s_len = s.length();
		int p_len = p.length();

		boolean[][] d = new boolean[s_len + 1][p_len + 1];
		d[0][0] = true;

		for (int i = 0; i < p_len; i++) {
			if (p.charAt(i) == '*')
				d[0][i + 1] = d[0][i];
		}

		for (int i = 0; i < s_len; i++) {
			for (int j = 0; j < p_len; j++) {
				if (p.charAt(j) == '?')
					d[i + 1][j + 1] = d[i][j];
				if (p.charAt(j) == s.charAt(i))
					d[i + 1][j + 1] = d[i][j];
				if (p.charAt(j) == '*')
					d[i + 1][j + 1] = d[i + 1][j] || d[i][j + 1];
			}
		}

		return d[s_len][p_len];

	}
}
