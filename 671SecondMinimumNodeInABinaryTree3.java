package com.leetcode.SecondMinimumNodeInABinaryTree;

public class SecondMinimumNodeInABinaryTree3 {

	public static void main(String[] args) {

		TreeNode node21 = new TreeNode(2);
		TreeNode node22 = new TreeNode(2);
		TreeNode node51 = new TreeNode(5);
		TreeNode node52 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);

		node21.left = node22;
		node21.right = node51;
		node51.left = node52;
		node52.right = node7;

		System.out.println(findSecondMinimumValue(node21));

	}

	public static int findSecondMinimumValue(TreeNode root) {

		if (root == null)
			return -1;

		int l = (root.left != null && root.left.val != root.val) ? root.left.val : findSecondMinimumValue(root.left);
		int r = (root.right != null && root.right.val != root.val) ? root.right.val
				: findSecondMinimumValue(root.right);

		if (l == -1 || r == -1)
			return Math.max(l, r);
		
		return Math.min(l, r);

	}
}
