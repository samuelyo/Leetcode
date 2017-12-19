package com.leetcode.BaseballGame;

import java.util.Stack;

public class BaseballGame3 {

	public static void main(String[] args) {
		
		String[] ops = {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(ops));

	}
	
	public static int calPoints(String[] ops) {
		
		int sum = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0;i<ops.length;i++) {
			String cur = ops[i];
			if(cur.equals("C")) {
				sum -= stack.peek();
				stack.pop();
			}else if(cur.equals("D")) {
				sum += 2 * stack.peek();
				stack.push(2 * stack.peek());
			}else if(cur.equals("+")) {
				int num1 = stack.peek();
				stack.pop();
				int num2 = stack.peek();
				stack.push(num1);
				sum += num1 + num2;
				stack.push(num1 + num2);
			}
			else {
				sum += Integer.valueOf(cur);
				stack.push(Integer.valueOf(cur));
			}
		}
		return sum;
		
	}

}
