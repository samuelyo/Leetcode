package com.leetcode.RecoverBinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecoverBinarySearchTree3 {

	public static void main(String[] args) {

		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		node5.left = node3;
		node5.right = node4;

		recoverTree(node5);

		List<Integer> res = inOrderTraversal(node5);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static void recoverTree(TreeNode root) {

		List<TreeNode> eNodes = new LinkedList<TreeNode>(); // error nodes
		if (root == null)
			return;
		TreeNode current = root;
		TreeNode pre;
		TreeNode previous = null;
		while (current != null) {

			if (current.left == null) {

				if (previous != null && previous.val > current.val) {
					eNodes.add(previous);
					eNodes.add(current);
				}
				previous = current;
				current = current.right;

			} else {
				pre = current.left;
				while (pre.right != null && pre.right.val != current.val) {
					pre = pre.right;
				}

				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					if (previous != null && previous.val > current.val) {
						eNodes.add(previous);
						eNodes.add(current);
					}

					pre.right = null;
					previous = current;
					current = current.right;
				}
			}
		}

		// this is redundant check
		// if(eNodes.size() == 0) return;

		if (eNodes.size() == 2) {
			pre = eNodes.get(0);
			current = eNodes.get(1);
		} else { // this case where eNodes.size()==4
			pre = eNodes.get(0);
			current = eNodes.get(3);
		}

		int temp = pre.val;
		pre.val = current.val;
		current.val = temp;

	}

	public static List<Integer> inOrderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		list.addAll(inOrderTraversal(root.left));
		list.add(root.val);
		list.addAll(inOrderTraversal(root.right));
		return list;

	}
}
