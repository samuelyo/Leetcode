package com.leetcode.MiniParser;

import java.util.Stack;

public class MiniParser5 {

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
		NestedInteger cur = null;
		int start = 0;
		for(int i = 0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '[') { 
				if(cur != null) {
					stack.push(cur);
				}
				cur = new NestedIntegerImpl();
				start = i + 1;
			}else if(c == ']') {
				String temp = s.substring(start, i);
				if(temp.length() != 0) {
					cur.add(new NestedIntegerImpl(Integer.valueOf(temp)));
				}
				if(!stack.isEmpty()) {
					NestedInteger n = stack.pop();
					n.add(cur);
					cur = n;
				}
				start = i + 1;
			}else if(c == ',') {
				String temp = s.substring(start, i);
				if(temp.length() != 0) {
					cur.add(new NestedIntegerImpl(Integer.valueOf(temp)));
				}
				start = i + 1;
			}
		}
		return cur;
		
	}

}
