package com.leetcode.TwoSumIVInputIsABST;

import java.util.HashSet;

public class TwoSumIVInputIsABST2 {

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

		HashSet<Integer> set = new HashSet<Integer>();
		return dfs(root, set, k);
		
	}

	public static boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
		
		if (root == null)
			return false;
		if (set.contains(k - root.val))
			return true;
		set.add(root.val);
		return dfs(root.left, set, k) || dfs(root.right, set, k);

	}
}
