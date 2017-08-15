package com.leetcode.TwoSumIVInputIsABST;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputIsABST3 {

	public static void main(String[] args) {

		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);

		node5.left = node3;
		node5.right = node6;
		node3.left = node2;
		node3.right = node4;
		node6.right = node7;

		System.out.println(findTarget(node5, 28));

	}

	public static boolean findTarget(TreeNode root, int k) {

		List<Integer> nums = new ArrayList<>();
		inorder(root, nums);
		for (int i = 0, j = nums.size() - 1; i < j;) {
			if (nums.get(i) + nums.get(j) == k)
				return true;
			if (nums.get(i) + nums.get(j) < k)
				i++;
			else
				j--;
		}
		return false;
	}

	public static void inorder(TreeNode root, List<Integer> nums) {
		if (root == null)
			return;
		inorder(root.left, nums);
		nums.add(root.val);
		inorder(root.right, nums);

	}
}
