package com.leetcode.RemoveKDigits;

import java.util.Stack;

public class RemoveKDigits4 {

	public static void main(String[] args) {
		
		String num = "4321";
		int k = 2;
		
		String res = removeKdigits(num, k);
		System.out.println(res);

	}

	public static String removeKdigits(String num, int k) {
		
		if(num.length() == 0 || num.length() <= k){
			return "0";
		}
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i<num.length();i++){
			Character cur = num.charAt(i);
			while(!stack.isEmpty() && stack.peek() > cur && (stack.size() + num.length() - i - 1 >= num.length() - k)){
				stack.pop();
			}
			if(stack.size() < num.length() - k){
				stack.push(cur);
			}
		}
		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()){
			res.insert(0, stack.pop());
		}
		while(res.charAt(0) == '0' && res.length() > 1){
			res.deleteCharAt(0);
		}
		return res.toString();
		
	}
}
