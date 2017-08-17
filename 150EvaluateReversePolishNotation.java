package com.leetcode.EvaluateReversePolishNotation;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		
		String[] tokens = {"0","3","/"};
		System.out.println(evalRPN(tokens));

	}

	public static int evalRPN(String[] tokens) {
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0;i<tokens.length;i++){
			if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
				int right = stack.pop();
				int left = stack.pop();
				int res ;
				if(tokens[i].equals("+")){
					res = left + right;
				}else if(tokens[i].equals("-")){
					res = left - right;
				}else if(tokens[i].equals("*")){
					res = left * right;
				}else{
					res = left / right;
				}
				stack.push(res);
			}else{
				int cur = Integer.valueOf(tokens[i]);
				stack.push(cur);
			}
		}
		return stack.pop();
	}
	
}
