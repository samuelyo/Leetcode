package com.leetcode.CountCompleteTreeNodes;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes4 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;

		System.out.println(countNodes(root));

	}

	public static int countNodes(TreeNode root) {

		if (root == null)
			return 0;
		TreeNode left = root, right = root;
		int height = 0;
		while (right != null) {
			left = left.left;
			right = right.right;
			height++;
		}
		if (left == null)
			return (1 << height) - 1;
		return 1 + countNodes(root.left) + countNodes(root.right);

	}
}
