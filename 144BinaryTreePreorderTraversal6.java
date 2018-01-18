package com.leetcode.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal6 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
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
		while(root != null || !stack.isEmpty()) {
			TreeNode cur = root;
			while(cur != null) {
				stack.push(cur);
				res.add(cur.val);
				cur = cur.left;
			}
			if(!stack.isEmpty()) {
				root = stack.pop().right;
			}else {
				root = null;
			}
		}
		return res;
		
	}

}
