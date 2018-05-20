package com.leetcode.SimilarStringGroups;

public class SimilarStringGroups2 {

	public static void main(String[] args) {

		String[] A = { "tars", "rats", "arts", "star" };
		int res = numSimilarGroups(A);
		System.out.println(res);

	}

	public static int numSimilarGroups(String[] A) {

		if (A.length < 2) {
			return A.length;
		}
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == null) {
				continue;
			}
			String str = A[i];
			A[i] = null;
			res++;
			dfs(A, str);
		}
		return res;

	}

	public static void dfs(String[] strs, String str) {

		for (int i = 0; i < strs.length; i++) {
			if (strs[i] == null) {
				continue;
			}
			if (isSimilar(str, strs[i])) {
				String s = strs[i];
				strs[i] = null;
				dfs(strs, s);
			}
		}
	}

	public static boolean isSimilar(String s1, String s2) {
		int length = s1.length();
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
		}
		return count == 2;
	}

}
