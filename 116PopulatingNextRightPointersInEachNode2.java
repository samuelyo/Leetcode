package com.leetcode.PopulatingNextRightPointersInEachNode;

public class PopulatingNextRightPointersInEachNode2 {

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

	}

	public static void connect(TreeLinkNode root) {

		if (root == null) {
			return;
		}
		TreeLinkNode pre = root;
		TreeLinkNode cur = null;
		while (pre.left != null) {
			cur = pre;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null)
					cur.right.next = cur.next.left;
				cur = cur.next;
			}
			pre = pre.left;
		}

	}

}
