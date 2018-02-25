package com.leetcode.RemoveKDigits;

import java.util.Stack;

public class RemoveKDigits5 {

	public static void main(String[] args) {
		
		String num = "1432219";
		int k = 3;
		System.out.println(removeKdigits(num, k));

	}
	
	public static String removeKdigits(String num, int k) {
		
		if(num == null || num.length() == 0) {
			return "0";
		}
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i<num.length();i++) {
			char cur = num.charAt(i);
			while(k > 0 && !stack.isEmpty() && stack.peek() > cur) {
				stack.pop();
				k --;
			}
			stack.push(cur);
		}
		while(k > 0) {
			stack.pop();
			k --;
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		int index = 0;
		while(index < sb.length() && sb.charAt(index) == '0') {
			index ++;
		}
		return index == sb.length() ? "0" : sb.substring(index).toString();
		
	}

}
