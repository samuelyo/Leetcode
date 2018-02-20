package com.leetcode.MiniParser;

import java.util.Stack;

public class MiniParser4 {

	public static void main(String[] args) {
		
		String s = "[123,[456,[789]]]";
		NestedInteger n = deserialize(s);

	}
	
	public static NestedInteger deserialize(String s) {
		
		if(s == null || s.length() == 0) {
			return null;
		}
		if(s.charAt(0) != '[') {
			return new NestedIntegerImpl(Integer.valueOf(s));
		}
		Stack<NestedInteger> stack = new Stack<NestedInteger>();
		NestedInteger res = new NestedIntegerImpl();
		stack.push(res);
		int start = 1;
		for(int i = 1;i<s.length();i++) {
			char cur = s.charAt(i);
			if(cur == '[') {
				NestedInteger temp = new NestedIntegerImpl();
				stack.peek().add(temp);
				stack.push(temp);
				start = i + 1;
			}else if(cur == ']' || cur == ','){
				if(i > start) {
					stack.peek().add(new NestedIntegerImpl(Integer.valueOf(s.substring(start, i))));
				}
				if(cur == ']') {
					stack.pop();
				}
				start = i + 1;
			}
		}
		return res;
		
	}

}
