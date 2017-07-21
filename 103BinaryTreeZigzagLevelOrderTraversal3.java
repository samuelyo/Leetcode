package com.leetcode.BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal3 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);

		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;

		List<List<Integer>> res = zigzagLevelOrder(root);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> cur = res.get(i);
			for (int j = 0; j < cur.size(); j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null){
			return res;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		boolean order = true;
		int size = 1;

		while (!q.isEmpty()) {
			List<Integer> tmp = new ArrayList<Integer>();
			for (int i = 0; i < size; ++i) {
				TreeNode n = q.poll();
				if (order) {
					tmp.add(n.val);
				} else {
					tmp.add(0, n.val);
				}
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
			}
			res.add(tmp);
			size = q.size();
			order = order ? false : true;
		}
		return res;
	}

}
