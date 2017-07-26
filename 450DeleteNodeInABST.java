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

		// ���Ȳ��ҽڵ㣬����¼�ýڵ�ĸ��ڵ�����
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

		// ������������ɾ���ڵ�
		if (current.left == null && current.right == null) { // Ҫɾ���Ľڵ�û���ӽڵ�
			if (current == root) { // ���ڵ��ɾ��������
				root = null;
			} else if (isLeftNode) { // �������ڵ㣬���ڵ�ָ���
				parent.left = null;
			} else { // ������ҽڵ㣬�ҽڵ�ָ���
				parent.right = null;
			}
		} else if (current.left == null) { // Ҫɾ���Ľڵ�ֻ���ҽڵ�
			if (current == root) {
				root = current.right;
			} else if (isLeftNode) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (current.right == null) { // Ҫɾ���Ľڵ�ֻ����ڵ�
			if (current == root) {
				root = current.left;
			} else if (isLeftNode) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else { // Ҫɾ���Ľڵ��������ڵ�
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
