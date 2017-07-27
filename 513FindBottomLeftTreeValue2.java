package com.leetcode.FindBottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue2 {

	public static void main(String[] args) {

		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node5.left = node7;
		node7.left = node8;

		// node3.left = node1;
		// node3.right = node5;
		// node1.left = node0;
		// node1.right = node2;
		// node5.left = node4;
		// node5.right = node6;
		// node2.right = node3;

		System.out.println(findBottomLeftValue(node1));

	}

	public static int findBottomLeftValue(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (root.right != null)
				queue.add(root.right);
			if (root.left != null)
				queue.add(root.left);
		}
		return root.val;
		
	}
}
