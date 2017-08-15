package com.leetcode.TwoSumIVInputIsABST;

public class TwoSumIVInputIsABST4 {

	public static void main(String[] args) {

		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);

		node5.left = node3;
		node5.right = node6;
		node3.left = node2;
		node3.right = node4;
		node6.right = node7;

		System.out.println(findTarget(node5, 28));

	}

	public static boolean findTarget(TreeNode root, int k) {

		return dfs(root, root, k);
	}

	public static boolean dfs(TreeNode root, TreeNode cur, int k) {
		if (cur == null)
			return false;
		return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
	}

	public static boolean search(TreeNode root, TreeNode cur, int value) {
		if (root == null)
			return false;
		return (root.val == value) && (root != cur) || (root.val < value) && search(root.right, cur, value)
				|| (root.val > value) && search(root.left, cur, value);

	}
}
