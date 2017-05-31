package com.leetcode.FindModeinBinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindModeinBinarySearchTree3 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(2);
		// TreeNode t4 = new TreeNode(3);
		// TreeNode t5 = new TreeNode(3);

		t1.right = t2;
		t2.left = t3;
		t2.right = t4;
		// t2.right = t4;
		// t4.left = t5;

		int[] res = findMode(t1);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	private static int currVal;
	private static int currCount = 0;
	private static int maxCount = 0;
	private static int modeCount = 0;

	private static int[] modes;

	public static int[] findMode(TreeNode root) {

		inorder(root);
		modes = new int[modeCount];
		modeCount = 0;
		currCount = 0;
		inorder(root);
		return modes;
	}

	private static void handleValue(int val) {
		if (val != currVal) {
			currVal = val;
			currCount = 0;
		}
		currCount++;
		if (currCount > maxCount) {
			maxCount = currCount;
			modeCount = 1;
		} else if (currCount == maxCount) {
			if (modes != null)
				modes[modeCount] = currVal;
			modeCount++;
		}
	}

	//Morris traversal
	private static void inorder(TreeNode root) {
		TreeNode node = root;
		while (node != null) {
			if (node.left == null) {
				handleValue(node.val);
				node = node.right;
			} else {
				TreeNode prev = node.left;
				while (prev.right != null && prev.right != node)
					prev = prev.right;
				if (prev.right == null) {
					prev.right = node;
					node = node.left;
				} else {
					prev.right = null;
					handleValue(node.val);
					node = node.right;
				}
			}
		}
	}

}
