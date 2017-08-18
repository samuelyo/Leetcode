package com.leetcode.RemoveKDigits;

import java.util.Stack;

public class RemoveKDigits {

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
			while(k > 0 && !stack.isEmpty() && stack.peek() > cur){
				stack.pop();
				k --;
			}
//			if(stack.size() < num.length() - k){
//				stack.push(cur);
//			}
			
			stack.push(cur);
			
			
		}
		while(k > 0){
			stack.pop();
			k --;
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
