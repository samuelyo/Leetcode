package com.leetcode.RepeatedStringMatch;

public class RepeatedStringMatch2 {

	public static void main(String[] args) {

		String A = "baaabbbaba";
		String B = "baaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbaba";
		System.out.println(repeatedStringMatch(A, B));

	}

	public static int repeatedStringMatch(String A, String B) {

		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (sb.length() < B.length()) {
			sb.append(A);
			count++;
		}
		if (sb.toString().contains(B))
			return count;
		if (sb.append(A).toString().contains(B))
			return ++count;
		return -1;
	}
}
