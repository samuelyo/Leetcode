package com.leetcode.CountCompleteTreeNodes;

public class CountCompleteTreeNodes5 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		root.left = node2;
		root.right = node3;
		node2.left = node4;

		System.out.println(countNodes(root));

	}

	public static int countNodes(TreeNode root) {

		int hLeft = leftHeightOfTree(root);
		int rLeft = rightHeightOfTree(root);
		if(hLeft == rLeft) {
			return (1 << hLeft) - 1;
		}else {
			return 1 + countNodes(root.right) + countNodes(root.left);
		}

	}

	public static int leftHeightOfTree(TreeNode root) {

		if (root == null) {
			return 0;
		}
		return 1 + leftHeightOfTree(root.left);

	}

	public static int rightHeightOfTree(TreeNode root) {

		if (root == null) {
			return 0;
		}
		return 1 + rightHeightOfTree(root.right);

	}

}
