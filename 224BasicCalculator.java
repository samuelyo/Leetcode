package com.leetcode.BasicCalculator;

import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {
		
		String s = "13-(2-3)";
		System.out.println(calculate(s));

	}
	
	public static int calculate(String s) {
		
		if(s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		int res = 0;
		int sign = 1;
		int num = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0;i<len;i++) {
			if(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
				
				num = num * 10 + s.charAt(i) - '0';
				
			}else if(s.charAt(i) == '+') {
				res += sign * num;
				sign = 1;
				num = 0;
			}else if(s.charAt(i) == '-') {
				res += sign * num;
				sign = -1;
				num = 0;
			}else if(s.charAt(i) == '(') {
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
			}else if(s.charAt(i) == ')') {
				res += sign * num;
				num = 0;
				int si = stack.pop();
				int pre = stack.pop();
				res = pre + si * res;
			}
 		}
		res += sign * num;
		return res;
		
	}

}
