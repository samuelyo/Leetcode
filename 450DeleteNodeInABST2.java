package com.leetcode.DeleteNodeInABST;

public class DeleteNodeInABST2 {

	public static void main(String[] args) {

		// TreeNode root = new TreeNode(5);
		// TreeNode node3 = new TreeNode(3);
		// TreeNode node6 = new TreeNode(6);
		// TreeNode node2 = new TreeNode(2);
		// TreeNode node4 = new TreeNode(4);
		// TreeNode node7 = new TreeNode(7);
		//
		// root.left = node3;
		// root.right = node6;
		// node3.left = node2;
		// node3.right = node4;
		// node6.right = node7;

		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);

		root.right = node2;

		TreeNode res = deleteNode(root, 1);

	}

	public static TreeNode deleteNode(TreeNode root, int key) {

		if (root == null) {
			return null;
		}
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			TreeNode minNode = findMin(root.right);
			root.val = minNode.val;
			root.right = deleteNode(root.right, root.val);
		}
		return root;
	}

	private static TreeNode findMin(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;

	}
}
