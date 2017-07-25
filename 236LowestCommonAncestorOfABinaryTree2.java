package com.leetcode.LowestCommonAncestorOfABinaryTree;

public class LowestCommonAncestorOfABinaryTree2 {

	public static void main(String[] args) {

		// TreeNode root = new TreeNode(3);
		// TreeNode node5 = new TreeNode(5);
		// TreeNode node1 = new TreeNode(1);
		// TreeNode node6 = new TreeNode(6);
		// TreeNode node2 = new TreeNode(2);
		// TreeNode node0 = new TreeNode(0);
		// TreeNode node8 = new TreeNode(8);
		// TreeNode node7 = new TreeNode(7);
		// TreeNode node4 = new TreeNode(4);

		// root.left = node5;
		// root.right = node1;
		// node5.left = node6;
		// node5.right = node2;
		// node1.left = node0;
		// node1.right = node8;
		// node2.left = node7;
		// node2.right = node4;

		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		root.left = node2;

		TreeNode res = lowestCommonAncestor(root, node2, root);
		System.out.println(res.val);

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;

	}

}
