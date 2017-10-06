package com.leetcode.BinaryTreeMaximumPathSum;

public class BinaryTreeMaximumPathSum2 {

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		node1.left = node2;
		node1.right = node3;

		System.out.println(maxPathSum(node1));

	}

	public static int maxValue;

	// A path from start to end, goes up on the tree for 0 or more steps, then
	// goes down for 0 or more steps. Once it goes down, it can't go up. Each
	// path has a highest node, which is also the lowest common ancestor of all
	// other nodes on the path.

	// A recursive method maxPathDown(TreeNode node) (1) computes the maximum
	// path sum with highest node is the input node, update maximum if necessary
	// (2) returns the maximum sum of the path that can be extended to input
	// node's parent.
	public static int maxPathSum(TreeNode root) {

		maxValue = Integer.MIN_VALUE;
		maxPathDown(root);
		return maxValue;
	}

	public static int maxPathDown(TreeNode node) {

		if (node == null)
			return 0;
		int left = Math.max(0, maxPathDown(node.left));
		int right = Math.max(0, maxPathDown(node.right));
		maxValue = Math.max(maxValue, left + right + node.val);
		return Math.max(left, right) + node.val;
	}
}
