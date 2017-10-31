package com.leetcode.ConvertSortedArrayToBinarySearchTree;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree3 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };
		TreeNode t = sortedArrayToBST(nums);
		t.inOrderTraverse(t);

	}

	public static TreeNode sortedArrayToBST(int[] nums) {

		if(nums == null || nums.length == 0) {
			return null;
		}
		int len = nums.length;
		int mid ;
		if(len % 2 == 1) {
			mid = len / 2;
		}else {
			mid = len / 2 - 1;
		}
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
		node.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
		return node;
	}

}
