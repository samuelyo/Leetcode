package com.leetcode.PopulatingNextRightPointersInEachNode;

public class PopulatingNextRightPointersInEachNode4 {

	public static void main(String[] args) {

		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node1 = new TreeLinkNode(2);
		TreeLinkNode node2 = new TreeLinkNode(3);
		TreeLinkNode node3 = new TreeLinkNode(4);
		TreeLinkNode node4 = new TreeLinkNode(5);
		TreeLinkNode node5 = new TreeLinkNode(6);
		TreeLinkNode node6 = new TreeLinkNode(7);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;

		connect(root);
		System.out.println();

	}

	public static void connect(TreeLinkNode root) {

		while (root != null) {
			TreeLinkNode p = root;
			while (p != null && p.left != null) {
				p.left.next = p.right;
				p.right.next = p.next == null ? null : p.next.left;
				p = p.next;
			}
			root = root.left;
		}

	}

}
