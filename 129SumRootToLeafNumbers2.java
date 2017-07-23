package com.leetcode.SumRootToLeafNumbers;

public class SumRootToLeafNumbers2 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		root.left = node2;
		root.right = node3;

		System.out.println(sumNumbers(root));

	}

	public static int sumNumbers(TreeNode root) {

		return sum(root, 0);
	}

	public static int sum(TreeNode n, int s) {
		if (n == null)
			return 0;
		if (n.right == null && n.left == null)
			return s * 10 + n.val;
		return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
	}

}
