package com.leetcode.ScoreOfParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ScoreOfParentheses {

	public static void main(String[] args) {

		String S = "(()(()))";
		int res = scoreOfParentheses(S);
		System.out.println(res);

	}

	public static int scoreOfParentheses(String S) {

		if (S == null || S.length() == 0) {
			return 0;
		}
		char[] chs = S.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < chs.length; i++) {
			char ch = chs[i];
			if (ch == '(') {
				stack.push(-1);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				while (!stack.isEmpty()) {
					Integer cur = stack.pop();
					if (cur != -1) {
						list.add(cur);
					} else {
						break;
					}
				}
				int num = 0;
				for (int j = 0; j < list.size(); j++) {
					num += list.get(j);
				}
				stack.push(num == 0 ? 1 : 2 * num);
			}
		}
		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}

}
