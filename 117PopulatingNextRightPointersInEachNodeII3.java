package com.leetcode.PopulatingNextRightPointersInEachNodeII;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeII3 {

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

		TreeLinkNode head = root;// The left most node in the lower level
		TreeLinkNode prev = null;// The previous node in the lower level
		TreeLinkNode curr = null;// The current node in the upper level
		while (head != null) {
			curr = head;
			prev = null;
			head = null;
			// iterate on the current level
			while (curr != null) {
				// left child
				if (curr.left != null) {
					if (prev != null)
						prev.next = curr.left;
					else
						head = curr.left;
					prev = curr.left;
				}
				// right child
				if (curr.right != null) {
					if (prev != null)
						prev.next = curr.right;
					else
						head = curr.right;
					prev = curr.right;
				}
				// move to next node
				curr = curr.next;
			}
		}
		
	}
}
