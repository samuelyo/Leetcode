package com.leetcode.CountOfSmallerNumbersAfterSelf;

import java.util.Arrays;
import java.util.List;

class TreeNode {
	int smallCount;
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int count, int val) {
		this.smallCount = count;
		this.val = val;
	}
}

public class CountOfSmallerNumbersAfterSelf4 {

	public static void main(String[] args) {

		int[] nums = { 5, 2, 6, 1 };
		List<Integer> res = countSmaller(nums);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> countSmaller(int[] nums) {

		TreeNode root = null;
		Integer[] ret = new Integer[nums.length];
		if (nums == null || nums.length == 0)
			return Arrays.asList(ret);
		for (int i = nums.length - 1; i >= 0; i--) {
			root = insert(root, nums[i], ret, i, 0);
		}
		return Arrays.asList(ret);
	}

	public static TreeNode insert(TreeNode root, int val, Integer[] ans, int index, int preSum) {
		
		if (root == null) {
			root = new TreeNode(0, val);
			ans[index] = preSum;
		} else if (root.val > val) {
			root.smallCount++;
			root.left = insert(root.left, val, ans, index, preSum);
		} else {
			root.right = insert(root.right, val, ans, index, root.smallCount + preSum + (root.val < val ? 1 : 0)); //only adding 1 on preSum if root.val is only smaller than val
        }
        return root;

	}
}
