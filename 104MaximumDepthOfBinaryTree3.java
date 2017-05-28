package com.leetcode.MaximumDepthOfBinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumDepthOfBinaryTree3 {

	public static void main(String[] args) {

		TreeNode p = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(5);
		p.left = p1;
		p.right = p2;
		p1.left = p3;
		p2.right = p4;

		System.out.println(maxDepth(p));

	}

	public static int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		Deque<TreeNode> stack = new LinkedList<TreeNode>();

		stack.push(root);
		int count = 0;

		while (!stack.isEmpty()) {
			int size = stack.size();
			while (size-- > 0) {
				TreeNode cur = stack.pop();
				if (cur.left != null)
					stack.addLast(cur.left);
				if (cur.right != null)
					stack.addLast(cur.right);
			}
			count++;

		}
		return count;
	}

}
