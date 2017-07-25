package com.leetcode.CountCompleteTreeNodes;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes3 {

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

		int nodes = 0, h = height(root);
		while (root != null) {
			if (height(root.right) == h - 1) {
				nodes += 1 << (h - 1);
				root = root.right;
			} else {
				nodes += 1 << (h - 2);
				root = root.left;
			}
			h--;
		}
		return nodes;
	}

	public static int height(TreeNode node) {

		return node == null ? 0 : 1 + height(node.left);
	}
}
