package com.leetcode.DecodeString;

import java.util.Stack;

public class DecodeString2 {

	public static void main(String[] args) {

		String s = "2[abc]3[cd]ef";
		String res = decodeString(s);
		System.out.println(res);

	}

	public static String decodeString(String s) {

		String res = "";
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<String> resStack = new Stack<String>();
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count = 10 * count + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.push(count);
			} else if (s.charAt(idx) == '[') {
				resStack.push(res);
				res = "";
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder temp = new StringBuilder(resStack.pop());
				int repeatTimes = countStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(res);
				}
				res = temp.toString();
				idx++;
			} else {
				res += s.charAt(idx++);
			}
		}
		return res;

	}
}
