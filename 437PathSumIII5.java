package com.leetcode.PathSumIII;

public class PathSumIII5 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(-2);
		TreeNode t3 = new TreeNode(-3);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(-2);
		TreeNode t7 = new TreeNode(-1);
		TreeNode t8 = new TreeNode(-2);
		TreeNode t9 = new TreeNode(1);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t4.left = t7;

		System.out.println(pathSum(t1, -1));

	}

	public static int pathSum(TreeNode root, int sum) {

		if (root == null)
			return 0;
		return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	private static int pathSumFrom(TreeNode node, int sum) {
		if (node == null)
			return 0;
		return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val)
				+ pathSumFrom(node.right, sum - node.val);
	}
}
