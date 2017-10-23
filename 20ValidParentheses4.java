package com.leetcode.ValidParentheses;

import java.util.Stack;

public class ValidParentheses4 {

	public static void main(String[] args) {
		
		String s = "[[]]";
		System.out.println(isValid(s));

	}
	
	public static boolean isValid(String s){
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i<s.length();i++) {
			char cur = s.charAt(i);
			if(cur == '(' || cur == '[' || cur == '{') {
				stack.push(cur);
			}else if(cur == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					return false;
				}else {
					stack.pop();
				}
			}else if(cur == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					return false;
				}else {
					stack.pop();
				}
			}else if(cur == '}') {
				if(stack.isEmpty() || stack.peek() != '{') {
					return false;
				}else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

}
