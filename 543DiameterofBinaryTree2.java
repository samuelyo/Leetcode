package com.leetcode.DiameterofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterofBinaryTree2 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;

		System.out.println(maxDepth(t1));

	}

	private static int max = 0;

	public static int diameterOfBinaryTree(TreeNode root) {

		int res = 0;
		if (root == null)
			return res;

		int cur = maxDepth(root.left) + maxDepth(root.right);
		int left = diameterOfBinaryTree(root.left);
		int right = diameterOfBinaryTree(root.right);

		return Math.max(cur, Math.max(left, right));
	}

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

	}
}
