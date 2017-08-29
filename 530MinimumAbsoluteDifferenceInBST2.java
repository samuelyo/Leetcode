package com.leetcode.MinimumAbsoluteDifferenceInBST;

public class MinimumAbsoluteDifferenceInBST2 {

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);

		node1.right = node3;
		node3.left = node2;

		System.out.println(getMinimumDifference(node1));

	}

	public static int min = Integer.MAX_VALUE;
	public static Integer prev = null;

	public static int getMinimumDifference(TreeNode root) {

		if (root == null)
			return min;

		getMinimumDifference(root.left);

		if (prev != null) {
			min = Math.min(min, root.val - prev);
		}
		prev = root.val;

		getMinimumDifference(root.right);

		return min;

	}

}
