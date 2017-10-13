package com.leetcode.LongestValidParentheses;

import java.util.Stack;

public class LongestValidParentheses2 {

	public static void main(String[] args) {

		String s = ")()())";
		System.out.println(longestValidParentheses(s));

	}

	public static int longestValidParentheses(String s) {

		int res = 0, start = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(')
				stack.push(i);
			else if (s.charAt(i) == ')') {
				if (stack.empty())
					start = i + 1;
				else {
					stack.pop();
					res = stack.empty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
				}
			}
		}
		return res;

	}
}
