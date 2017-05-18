package com.leetcode.validparentheses;

import java.util.Stack;

public class ValidParentheses3 {

	public static void main(String[] args) {

		String s = "[[]]";
		System.out.println(isValid(s));

	}

	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				stack.push('(');
				break;
			case '{':
				stack.push('{');
				break;
			case '[':
				stack.push('[');
				break;
			case ')':
				if (stack.size() == 0 || stack.pop() != '(')
					return false;
				break;
			case '}':
				if (stack.size() == 0 || stack.pop() != '{')
					return false;
				break;
			case ']':
				if (stack.size() == 0 || stack.pop() != '[')
					return false;
				break;
			}
		}
		return stack.isEmpty();

	}

}
