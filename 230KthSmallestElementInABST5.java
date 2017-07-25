package com.leetcode.KthSmallestElementInABST;

import java.util.Stack;

public class KthSmallestElementInABST5 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(8);
		TreeNode node4 = new TreeNode(4);
		TreeNode node10 = new TreeNode(10);
		TreeNode node1 = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);
		TreeNode node9 = new TreeNode(9);
		TreeNode node12 = new TreeNode(12);

		root.left = node4;
		root.right = node10;
		node4.left = node1;
		node4.right = node5;
		node10.left = node9;
		node10.right = node12;

		int k = 5;
		System.out.println(kthSmallest(root, k));

	}

	public static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<>();

		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (k != 0) {
			TreeNode n = st.pop();
			k--;
			if (k == 0)
				return n.val;
			TreeNode right = n.right;
			while (right != null) {
				st.push(right);
				right = right.left;
			}
		}

		return -1; // never hit if k is valid
	}
}
