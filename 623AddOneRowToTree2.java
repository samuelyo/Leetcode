package com.leetcode.AddOneRowToTree;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree2 {

	public static void main(String[] args) {

		// TreeNode root = new TreeNode(4);
		// TreeNode node2 = new TreeNode(2);
		// TreeNode node6 = new TreeNode(6);
		// TreeNode node3 = new TreeNode(3);
		// TreeNode node1 = new TreeNode(1);
		// TreeNode node5 = new TreeNode(5);

		// root.left = node2;
		// root.right = node6;
		// node2.left = node3;
		// node2.right = node1;
		// node6.left = node5;

		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		root.left = node2;
		root.right = node3;
		node2.left = node4;

		int v = 5;
		int d = 4;

		TreeNode res = addOneRow(root, v, d);
		System.out.println(res.val);

	}

	public static TreeNode addOneRow(TreeNode root, int v, int d) {

		//In addition to use 1 to indicate attach to left node as required, we can also use 0 to indicate attach to right node;
		if (d == 0 || d == 1) {
			TreeNode newroot = new TreeNode(v);
			newroot.left = d == 1 ? root : null;
			newroot.right = d == 0 ? root : null;
			return newroot;
		}
		if (root != null && d >= 2) {
			root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
			root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
		}
		return root;

	}
}
