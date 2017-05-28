package com.leetcode.ConvertSortedArrayToBinarySearchTree;

public class ConvertSortedArrayToBinarySearchTree {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		TreeNode t = sortedArrayToBST(nums);
		t.preOrderTraverse(t);

	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		
		if (nums.length == 0) {
	        return null;
	    }
	    TreeNode head = helper(nums, 0, nums.length - 1);
	    return head;
	}

	public static TreeNode helper(int[] nums, int low, int high) {
	    if (low > high) { // Done
	        return null;
	    }
	    int mid = low + (high-low)/2;
	    TreeNode node = new TreeNode(nums[mid]);
	    node.left = helper(nums, low, mid - 1);
	    node.right = helper(nums, mid + 1, high);
	    return node;
	}
	
	

}
