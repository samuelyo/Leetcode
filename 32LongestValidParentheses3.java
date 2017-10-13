package com.leetcode.LongestValidParentheses;

import java.util.Stack;

public class LongestValidParentheses3 {

	public static void main(String[] args) {

		String s = ")()())";
		System.out.println(longestValidParentheses(s));

	}
	
//	1、Scan the string from beginning to end.
//	2、If current character is '(',
//	push its index to the stack. If current character is ')' and the
//	character at the index of the top of stack is '(', we just find a
//	matching pair so pop from the stack. Otherwise, we push the index of
//	')' to the stack.
//	3、After the scan is done, the stack will only
//	contain the indices of characters which cannot be matched. Then
//	let's use the opposite side - substring between adjacent indices
//	should be valid parentheses.
//	4、If the stack is empty, the whole input
//	string is valid. Otherwise, we can scan the stack to get longest
//	valid substring as described in step 3.

	public static int longestValidParentheses(String s) {

		int len = s.length();
		int res = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0;i<len;i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			}else {
				if(!stack.isEmpty()) {
					if(s.charAt(stack.peek()) == '(') {
						stack.pop();
					}else{
						stack.push(i);
					}
				}else {
					stack.push(i);
				}
			}
		}
		if(stack.isEmpty()) {
			res = len;
		}else {
			int a = len;
			int b = 0;
			while(!stack.isEmpty()) {
				b = stack.pop();
				res = Math.max(res, a - b - 1);
				a = b;
			}
			res = Math.max(res, a);
		}
		return res;
		
	}
}
