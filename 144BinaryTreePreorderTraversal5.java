package com.leetcode.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal5 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		root.right = node2;
		node2.left = node3;
		
		List<Integer> ans = preorderTraversal(root);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}
		
	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
		
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null) {
			res.add(root.val);
			if(root.right != null) {
				stack.push(root.right);
			}
			root = root.left;
			if(root == null && stack.size() != 0) {
				root = stack.pop();
			}
		}
		return res;
		
	}

}
