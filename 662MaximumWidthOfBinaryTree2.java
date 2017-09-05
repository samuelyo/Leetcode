package com.leetcode.MaximumWidthOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree2 {

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

		return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
	}

	public static int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
		
		if (root == null)
			return 0;
		if (start.size() == level) {
			start.add(order);
			end.add(order);
		} else
			end.set(level, order);
		int cur = end.get(level) - start.get(level) + 1;
		int left = dfs(root.left, level + 1, 2 * order, start, end);
		int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
		return Math.max(cur, Math.max(left, right));
		
	}

}
