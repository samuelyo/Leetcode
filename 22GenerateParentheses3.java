package com.leetcode.GenerateParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GenerateParentheses3 {

	public static void main(String[] args) {

		int n = 2;
		List<String> ans = generateParenthesis(n);
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i) + " ");
		}

	}

	public static List<String> generateParenthesis(int n) {

		List<String> res = new ArrayList<>();
		helper(res, new StringBuilder(), 0, 0, n);
		return res;
	}

	private static void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
		if (open == n && close == n) {
			res.add(sb.toString());
			return;
		}

		if (open < n) {
			sb.append("(");
			helper(res, sb, open + 1, close, n);
			sb.setLength(sb.length() - 1);
		}
		if (close < open) {
			sb.append(")");
			helper(res, sb, open, close + 1, n);
			sb.setLength(sb.length() - 1);
		}
	}

}
