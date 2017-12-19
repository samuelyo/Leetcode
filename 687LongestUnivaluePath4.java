package com.leetcode.LongestUnivaluePath;

public class LongestUnivaluePath4 {

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

	public static int res = 0;

	public static int longestUnivaluePath(TreeNode root) {
		if (root == null)
			return 0;
		help(root);
		return res;
	}

	public static void help(TreeNode root) {
		if (root == null)
			return;
		int temp = count(root.left, root.val) + count(root.right, root.val);
		res = Math.max(res, temp);
		help(root.left);
		help(root.right);
	}

	public static int count(TreeNode root, int val) {
		
		if (root == null || root.val != val)
			return 0;
		int left = count(root.left, val) + 1;
		int right = count(root.right, val) + 1;

		return Math.max(left, right);
	}

}
