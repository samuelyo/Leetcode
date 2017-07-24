package com.leetcode.BinaryTreePostorderTraversal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal3 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

//		root.right = node2;
//		node2.left = node3;

		 root.left = node2;
		 root.right = node3;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node3.right = node7;

		List<Integer> res = postorderTraversal(root);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> postorderTraversal(TreeNode root) {

		LinkedList<Integer> result = new LinkedList<Integer>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				result.addFirst(p.val); // Reverse the process of preorder
				p = p.right; // Reverse the process of preorder
			} else {
				TreeNode node = stack.pop();
				p = node.left; // Reverse the process of preorder
			}
		}
		return result;
	}

}
