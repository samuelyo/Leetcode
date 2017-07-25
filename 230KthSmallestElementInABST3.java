package com.leetcode.KthSmallestElementInABST;

import java.util.Stack;

public class KthSmallestElementInABST3 {

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

	public static int kthSmallest(TreeNode root, int k) {
		
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
		}

		return root.val;
	}

	public static int countNodes(TreeNode n) {
		
		if (n == null)
			return 0;

		return 1 + countNodes(n.left) + countNodes(n.right);
	}

}
