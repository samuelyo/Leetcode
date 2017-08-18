package com.leetcode.RemoveKDigits;

import java.util.Stack;

public class RemoveKDigits3 {

	public static void main(String[] args) {

		String num = "10";
		int k = 2;

		String res = removeKdigits(num, k);
		System.out.println(res);

	}

	public static String removeKdigits(String num, int k) {

		int len = num.length();
		// corner case
		if (k == len)
			return "0";

		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		while (i < num.length()) {
			// whenever meet a digit which is less than the previous digit,
			// discard the previous one
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
			i++;
		}

		// corner case like "1111"
		while (k > 0) {
			stack.pop();
			k--;
		}

		// construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();

		// remove all the 0 at the head
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();

	}
}
