package com.leetcode.GenerateParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GenerateParentheses2 {

	public static void main(String[] args) {

		int n = 2;
		List<String> ans = generateParenthesis(n);
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i) + " ");
		}

	}

	public static List<String> generateParenthesis(int n) {

		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	public static void backtrack(List<String> list, String str, int open, int close, int max) {

		if (str.length() == max * 2) {
			list.add(str);
			return;
		}

		if (open < max)
			backtrack(list, str + "(", open + 1, close, max);
		if (close < open)
			backtrack(list, str + ")", open, close + 1, max);
	}

}
