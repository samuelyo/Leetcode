package com.leetcode.MiniParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MiniParser2 {

	public static void main(String[] args) {

		String s = "[123,[456,[789]]]";
		NestedInteger n = deserialize(s);

	}

	public static NestedInteger deserialize(String s) {

		if (!s.startsWith("[")) {
			return new NestedIntegerImpl(Integer.valueOf(s));
		}
		Stack<NestedInteger> stack = new Stack<>();
		NestedInteger res = new NestedIntegerImpl();
		stack.push(res);
		int start = 1;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') {
				NestedInteger ni = new NestedIntegerImpl();
				stack.peek().add(ni);
				stack.push(ni);
				start = i + 1;
			} else if (c == ',' || c == ']') {
				if (i > start) {
					Integer val = Integer.valueOf(s.substring(start, i));
					stack.peek().add(new NestedIntegerImpl(val));
				}
				start = i + 1;
				if (c == ']') {
					stack.pop();
				}
			}
		}
		return res;
	}

}
