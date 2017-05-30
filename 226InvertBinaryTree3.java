package com.leetcode.InvertBinaryTree;

public class InvertBinaryTree3 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(7);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(9);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;

		t1 = invertTree(t1);

		TreeNode.inOrderTraverse(t1);

	}

	public static TreeNode invertTree(TreeNode root) {

		if (root == null)
			return null;
		TreeNode tempRight = root.right;
		root.right = invertTree(root.left);
		root.left = invertTree(tempRight);
		return root;
	}
}
