package com.leetcode.MinimumDepthOfBinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepthOfBinaryTree2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;

		System.out.println(minDepth(t1));

	}

	public static int minDepth(TreeNode root) {

		if (root == null)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}

}
