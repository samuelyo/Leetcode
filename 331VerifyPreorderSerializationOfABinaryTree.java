package com.leetcode.VerifyPreorderSerializationOfABinaryTree;

import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {

	public static void main(String[] args) {
		
		String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(isValidSerialization(preorder));

	}
	
	public static boolean isValidSerialization(String preorder) {
		
		String[] preOrder = preorder.split(",");
		Stack<String> stack = new Stack<String>();
		for(int i = 0;i<preOrder.length;i++){
			String cur = preOrder[i];
			stack.push(cur);
			while(stack.size() >= 3){
				String b = stack.pop();
				String a = stack.pop();
				if(a.equals("#") && b.equals("#")){
					stack.pop();
					stack.push("#");
				}else{
					stack.push(a);
					stack.push(b);
					break;
				}
			}
			if(i != preOrder.length - 1 && stack.size() == 1 && stack.peek().equals("#")){
				return false;
			}
		}
		return stack.size() == 1 && stack.peek().equals("#");
	}

}
