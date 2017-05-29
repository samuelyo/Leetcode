package com.leetcode.PathSum;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		System.out.println(hasPathSum(t, 1));

	}

	public static boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;

		if (root.left == null && root.right == null)
			return sum == root.val;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

}
