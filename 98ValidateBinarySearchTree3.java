package com.leetcode.ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree3 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);

		root.left = left;
		root.right = right;

		System.out.println(isValidBST(root));

	}

	public static boolean isValidBST(TreeNode root) {

		if (root == null){
			return true;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && root.val <= pre.val){
				return false;
			}
			pre = root;
			root = root.right;
		}
		return true;

	}
}
