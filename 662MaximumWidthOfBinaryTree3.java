package com.leetcode.MaximumWidthOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree3 {

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node9 = new TreeNode(9);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		node1.left = node3;
		node1.right = node2;
		node3.left = node5;
		node2.right = node9;
		node5.left = node6;
		node9.right = node7;

		System.out.println(widthOfBinaryTree(node1));

	}

	public static int widthOfBinaryTree(TreeNode root) {

		List<Integer> lefts = new ArrayList<Integer>(); // left most nodes at
														// each level;
		int[] res = new int[1]; // max width
		dfs(root, 1, 0, lefts, res);
		return res[0];
		
	}

	private static void dfs(TreeNode node, int id, int depth, List<Integer> lefts, int[] res) {
		
		if (node == null)
			return;
		if (depth >= lefts.size())
			lefts.add(id); // add left most node
		res[0] = Integer.max(res[0], id + 1 - lefts.get(depth));
		dfs(node.left, id * 2, depth + 1, lefts, res);
		dfs(node.right, id * 2 + 1, depth + 1, lefts, res);

	}

}
