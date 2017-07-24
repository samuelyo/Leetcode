package com.leetcode.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView2 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		root.left = node2;
		root.right = node3;
		node3.right = node4;
		node2.right = node5;

		List<Integer> res = rightSideView(root);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> rightSideView(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	public static void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) {
			return;
		}
		if (currDepth == result.size()) {
			result.add(curr.val);
		}

		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);
	}

}
