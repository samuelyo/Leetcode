package com.leetcode.ScoreOfParentheses;

public class ScoreOfParentheses2 {

	public static void main(String[] args) {

		String S = "(()(()))";
		int res = scoreOfParentheses(S);
		System.out.println(res);

	}

	public static int scoreOfParentheses(String S) {

		int res = 0, layers = 0;
		for (int i = 0; i < S.length(); ++i) {
			if (S.charAt(i) == '(')
				layers++;
			else
				layers--;
			if (S.charAt(i) == '(' && S.charAt(i + 1) == ')')
				res += 1 << (layers - 1);
		}
		return res;
	}

}
