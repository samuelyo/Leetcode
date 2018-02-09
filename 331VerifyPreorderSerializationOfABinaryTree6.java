package com.leetcode.VerifyPreorderSerializationOfABinaryTree;

import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree6 {

	public static void main(String[] args) {
		
		String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(isValidSerialization(preorder));

	}
	
	public static boolean isValidSerialization(String preorder) {
		
		String[] pre = preorder.split(",");
		Stack<String> stack = new Stack<String>();
		for(int i = 0;i<=pre.length;i++) {
			while(!stack.isEmpty() && stack.size() >= 3) {
				String first = stack.pop();
				String second = stack.pop();
				if(first.equals("#") && second.equals("#")) {
					String s = stack.pop();
					if(s.equals("#")) {
						return false;
					}
					stack.push("#");
				}else {
					stack.push(second);
					stack.push(first);
					break;
				}
			}
			if(i < pre.length) {
				stack.push(pre[i]);
			}
		}
		return stack.size() == 1 && stack.peek().equals("#");
		
	}

}
