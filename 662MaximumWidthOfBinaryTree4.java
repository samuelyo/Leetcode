package com.leetcode.MaximumWidthOfBinaryTree;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthOfBinaryTree4 {

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

		if (root == null)
			return 0;
		int max = 0;
		Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<Map.Entry<TreeNode, Integer>>();
		q.offer(new AbstractMap.SimpleEntry(root, 1));

		while (!q.isEmpty()) {
			int l = q.peek().getValue(), r = l; // right started same as left
			for (int i = 0, n = q.size(); i < n; i++) {
				TreeNode node = q.peek().getKey();
				r = q.poll().getValue();
				if (node.left != null)
					q.offer(new AbstractMap.SimpleEntry(node.left, r * 2));
				if (node.right != null)
					q.offer(new AbstractMap.SimpleEntry(node.right, r * 2 + 1));
			}
			max = Math.max(max, r + 1 - l);
		}

		return max;
		
	}

}
