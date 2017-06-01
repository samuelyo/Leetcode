package com.leetcode.BinaryTreeTilt;

public class BinaryTreeTilt2 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;

		System.out.println(findTilt(t1));

	}

	private static int result = 0;

	public static int findTilt(TreeNode root) {

		postOrder(root);
		return result;
	}

	private static int postOrder(TreeNode root) {
		if (root == null)
			return 0;

		int left = postOrder(root.left); //sum of the left subtree
		int right = postOrder(root.right);//sum of the right subtree

		result += Math.abs(left - right);//for each node, sum the difference

		return left + right + root.val;
	}
}
