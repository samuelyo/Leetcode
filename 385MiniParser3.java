package com.leetcode.MiniParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MiniParser3 {

	public static void main(String[] args) {

		String s = "[123,[456,[789]]]";
		NestedInteger n = deserialize(s);

	}

	public static NestedInteger deserialize(String s) {

		if(s == null){
			return null;
		}
		if(s.charAt(0) != '['){
			return new NestedIntegerImpl(Integer.parseInt(s));
		}
		Stack<NestedInteger> stack = new Stack<NestedInteger>();
		NestedInteger cur = new NestedIntegerImpl();
		stack.push(cur);
		int start = 1;
		for(int i = 1;i<s.length();i++){
			if(s.charAt(i) == '['){
				NestedInteger n = new NestedIntegerImpl();
				stack.peek().add(n);
				stack.push(n);
				start = i + 1;
			}else if(s.charAt(i) == ']' || s.charAt(i) == ','){
				if(i > start){
					NestedInteger n = new NestedIntegerImpl(Integer.parseInt(s.substring(start, i)));
					stack.peek().add(n);
				}
				if(s.charAt(i) == ']'){
					stack.pop();
				}
				start = i + 1;
			}
		}
		return cur;
	}

}
