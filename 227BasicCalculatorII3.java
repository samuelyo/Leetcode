package com.leetcode.BasicCalculatorII;

import java.util.Stack;

public class BasicCalculatorII3 {

	public static void main(String[] args) {
		
		String s = " 3+5 / 2 ";
		System.out.println(calculate(s));
		
	}
	
	public static int calculate(String s) {
		
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for(int i = 0;i<=s.length();i++) {
			char cur = i < s.length() ? s.charAt(i) : '_';
			if(cur == ' ') {
				continue;
			}
			if(cur - '0' >= 0 && cur - '0' <= 9) {
				num = num * 10 + cur - '0';
			}else {
				if(sign == '+') {
					stack.push(num);
				}else if(sign == '-') {
					stack.push(-num);
				}else if(sign == '*') {
					int value1 = num;
					int value2 = stack.pop();
					stack.push(value2 * value1);
				}else {
					int value1 = num;
					int value2 = stack.pop();
					stack.push(value2 / value1);
				}
				num = 0;
				sign = cur;
			}
		}
		int res = 0;
		while(!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
		
	}

}
