package com.leetcode.KthSmallestElementInABST;

import java.util.Stack;

public class KthSmallestElementInABST4 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(8);
		TreeNode node4 = new TreeNode(4);
		TreeNode node10 = new TreeNode(10);
		TreeNode node1 = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);
		TreeNode node9 = new TreeNode(9);
		TreeNode node12 = new TreeNode(12);

		root.left = node4;
		root.right = node10;
		node4.left = node1;
		node4.right = node5;
		node10.left = node9;
		node10.right = node12;

		int k = 5;
		System.out.println(kthSmallest(root, k));

	}

	private static int number = 0;
	private static int count = 0;

	public static int kthSmallest(TreeNode root, int k) {
		count = k;
		helper(root);
		return number;
	}

	public static void helper(TreeNode n) {
		if (n.left != null)
			helper(n.left);
		count--;
		if (count == 0) {
			number = n.val;
			return;
		}
		if (n.right != null)
			helper(n.right);
	}

}
