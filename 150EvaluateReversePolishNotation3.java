package com.leetcode.EvaluateReversePolishNotation;

import java.util.Stack;

public class EvaluateReversePolishNotation3 {

	public static void main(String[] args) {
		
		String[] tokens = {"0","3","/"};
		System.out.println(evalRPN(tokens));

	}
	
	public static int evalRPN(String[] tokens) {
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0;i<tokens.length;i++) {
			String cur = tokens[i];
			if(cur.equals("+")) {
				Integer num2 = stack.pop();
				Integer num1 = stack.pop();
				int value = num1 + num2;
				stack.push(value);
			}else if(cur.equals("-")) {
				Integer num2 = stack.pop();
				Integer num1 = stack.pop();
				int value = num1 - num2;
				stack.push(value);
			}else if(cur.equals("*")) {
				Integer num2 = stack.pop();
				Integer num1 = stack.pop();
				int value = num1 * num2;
				stack.push(value);
			}else if(cur.equals("/")) {
				Integer num2 = stack.pop();
				Integer num1 = stack.pop();
				int value = num1 / num2;
				stack.push(value);
			}else {
				stack.push(Integer.valueOf(cur));
			}
		}
		return stack.peek();
		
	}

}
