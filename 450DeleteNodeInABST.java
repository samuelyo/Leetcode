package com.leetcode.DeleteNodeInABST;

public class DeleteNodeInABST {

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

		// 首先查找节点，并记录该节点的父节点引用
		TreeNode current = root;
		TreeNode parent = root;
		boolean isLeftNode = true;
		while (current != null && current.val != key) {
			parent = current;
			if (key < current.val) {
				isLeftNode = true;
				current = current.left;
			} else {
				isLeftNode = false;
				current = current.right;
			}
		}
		if (current == null) {
			return root;
		}

		// 下面分三种情况删除节点
		if (current.left == null && current.right == null) { // 要删除的节点没有子节点
			if (current == root) { // 根节点就删除整棵树
				root = null;
			} else if (isLeftNode) { // 如果是左节点，做节点指向空
				parent.left = null;
			} else { // 如果是右节点，右节点指向空
				parent.right = null;
			}
		} else if (current.left == null) { // 要删除的节点只有右节点
			if (current == root) {
				root = current.right;
			} else if (isLeftNode) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (current.right == null) { // 要删除的节点只有左节点
			if (current == root) {
				root = current.left;
			} else if (isLeftNode) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else { // 要删除的节点有两个节点
			TreeNode successor = findSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftNode) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return root;
	}

	private static TreeNode findSuccessor(TreeNode delNode) {
		TreeNode parent = delNode;
		TreeNode successor = delNode;
		TreeNode current = delNode.right;
		while (current != null) {
			parent = successor;
			successor = current;
			current = current.left;
		}
		if (successor != delNode.right) {
			parent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;
	}
}
