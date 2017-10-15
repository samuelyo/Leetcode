package com.leetcode.LongestUnivaluePath;

public class LongestUnivaluePath2 {

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node41 = new TreeNode(4);
		TreeNode node51 = new TreeNode(5);
		TreeNode node42 = new TreeNode(4);
		TreeNode node43 = new TreeNode(4);
		TreeNode node52 = new TreeNode(5);

		node1.left = node41;
		node1.right = node51;
		node41.left = node42;
		node41.right = node43;
		node51.right = node52;

		System.out.println(longestUnivaluePath(node1));

	}

	public static int longestUnivaluePath(TreeNode root) {

		int[] res = new int[1];
		if (root != null)
			dfs(root, res);
		return res[0];
	}

	private static int dfs(TreeNode node, int[] res) {
		int l = node.left != null ? dfs(node.left, res) : 0;
		int r = node.right != null ? dfs(node.right, res) : 0;
		int resl = node.left != null && node.left.val == node.val ? l + 1 : 0;
		int resr = node.right != null && node.right.val == node.val ? r + 1 : 0;
		res[0] = Math.max(res[0], resl + resr);
		return Math.max(resl, resr);
	}
}
