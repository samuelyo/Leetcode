package com.leetcode.MinimumAbsoluteDifferenceInBST;

import java.util.TreeSet;

public class MinimumAbsoluteDifferenceInBST3 {

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);

		node1.right = node3;
		node3.left = node2;

		System.out.println(getMinimumDifference(node1));

	}

	public static TreeSet<Integer> set = new TreeSet<>();
	public static int min = Integer.MAX_VALUE;

	public static int getMinimumDifference(TreeNode root) {

		if (root == null)
			return min;

		if (!set.isEmpty()) {
			if (set.floor(root.val) != null) {
				min = Math.min(min, root.val - set.floor(root.val));
			}
			if (set.ceiling(root.val) != null) {
				min = Math.min(min, set.ceiling(root.val) - root.val);
			}
		}

		set.add(root.val);

		getMinimumDifference(root.left);
		getMinimumDifference(root.right);

		return min;

	}

}
