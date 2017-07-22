package com.leetcode.PopulatingNextRightPointersInEachNodeII;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeII4 {

	public static void main(String[] args) {

		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		// TreeLinkNode node6 = new TreeLinkNode(6);
		// TreeLinkNode node7 = new TreeLinkNode(7);
		// TreeLinkNode node8 = new TreeLinkNode(8);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node3.right = node5;
		// node3.right = node6;
		// node4.left = node7;
		// node6.right = node8;

		connect(root);

	}

	public static void connect(TreeLinkNode root) {

		TreeLinkNode tempChild = new TreeLinkNode(0);
		while (root != null) {
			TreeLinkNode currentChild = tempChild;
			while (root != null) {
				if (root.left != null) {
					currentChild.next = root.left;
					currentChild = currentChild.next;
				}
				if (root.right != null) {
					currentChild.next = root.right;
					currentChild = currentChild.next;
				}
				root = root.next;
			}
			root = tempChild.next;
			tempChild.next = null;
		}

	}
}
