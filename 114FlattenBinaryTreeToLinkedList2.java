package com.leetcode.FlattenBinaryTreeToLinkedList;

public class FlattenBinaryTreeToLinkedList2 {

	public static void main(String[] args) {

		// TreeNode root = new TreeNode(1);
		// TreeNode node1 = new TreeNode(2);
		// TreeNode node2 = new TreeNode(5);
		// TreeNode node3 = new TreeNode(3);
		// TreeNode node4 = new TreeNode(4);
		// TreeNode node5 = new TreeNode(6);
		//
		// root.left = node1;
		// root.right = node2;
		// node1.left = node3;
		// node1.right = node4;
		// node2.right = node5;

		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(3);

		root.right = node1;
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;

		flatten(root);

	}

	public static TreeNode prev = null;

	public static void flatten(TreeNode root) {

		if (root == null){
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;

	}

}
