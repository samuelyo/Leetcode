package com.leetcode.FindLargestValueInEachTreeRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow2 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node3r = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);

		root.left = node3;
		root.right = node2;
		node3.left = node5;
		node3.right = node3r;
		node2.right = node9;

		List<Integer> list = largestValues(root);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	public static List<Integer> largestValues(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		helper(root, res, 0);
		return res;
	}

	public static void helper(TreeNode root, List<Integer> res, int d) {
		if (root == null) {
			return;
		}
		// expand list size
		if (d == res.size()) {
			res.add(root.val);
		} else {
			// or set value
			res.set(d, Math.max(res.get(d), root.val));
		}
		helper(root.left, res, d + 1);
		helper(root.right, res, d + 1);
	}
}
