package com.leetcode.SymmetricTree;

public class SymmetricTree2 {

	public static void main(String[] args) {

		TreeNode p = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(2);
		p.left = p1;
		p.right = p2;

		TreeNode p3 = new TreeNode(3);
		TreeNode p4 = new TreeNode(4);
		p1.left = p3;
		p1.right = p4;
		p2.left = p3;
		p2.right = p4;

		System.out.println(isSymmetric(p));

	}

	public static boolean isSymmetric(TreeNode root) {
		return root == null || isSymmetricHelp(root.left, root.right);
	}

	public static  boolean isSymmetricHelp(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;
		if (left.val != right.val)
			return false;
		return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}

}
