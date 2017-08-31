package com.leetcode.MaximumBinaryTree;

public class MaximumBinaryTree2 {

	public static void main(String[] args) {

		int[] nums = { 3, 2, 1, 6, 0, 5 };
		TreeNode res = constructMaximumBinaryTree(nums);
		preOrder(res);

	}

	public static TreeNode constructMaximumBinaryTree(int[] nums) {

		if (nums == null)
			return null;
		return build(nums, 0, nums.length - 1);
	}

	public static TreeNode build(int[] nums, int start, int end) {
		
		if (start > end)
			return null;

		int idxMax = start;
		for (int i = start + 1; i <= end; i++) {
			if (nums[i] > nums[idxMax]) {
				idxMax = i;
			}
		}

		TreeNode root = new TreeNode(nums[idxMax]);

		root.left = build(nums, start, idxMax - 1);
		root.right = build(nums, idxMax + 1, end);

		return root;

	}

	public static void preOrder(TreeNode root) {

		if (root == null) {
			return;
		}
		preOrder(root.left);
		System.out.print(root.val + " ");
		preOrder(root.right);

	}
}
