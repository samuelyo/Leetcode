package com.leetcode.MaximumBinaryTree;

public class MaximumBinaryTree {

	public static void main(String[] args) {
		
		int[] nums = {3,2,1,6,0,5};
		TreeNode res = constructMaximumBinaryTree(nums);
		preOrder(res);

	}

	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		
		if(nums == null || nums.length == 0){
			return null;
		}
		return constructMaximumBinaryTreeHelp(nums, 0, nums.length - 1);
		
	}
	
	public static TreeNode constructMaximumBinaryTreeHelp(int[] nums, int start, int end) {
		
		if(start > end){
			return null;
		}
		int maxIndex = 0;
		int maxValue = Integer.MIN_VALUE;
		for(int i = start;i<=end;i++){
			if(nums[i] > maxValue){
				maxIndex = i;
				maxValue = nums[i];
			}
		}
		TreeNode cur = new TreeNode(nums[maxIndex]);
		cur.left = constructMaximumBinaryTreeHelp(nums, start, maxIndex - 1);
		cur.right = constructMaximumBinaryTreeHelp(nums, maxIndex + 1, end);
		return cur;
		
	}
	public static void preOrder(TreeNode root) {
		
		if(root == null){
			return ;
		}
		preOrder(root.left);
		System.out.print(root.val + " ");
		preOrder(root.right);
		
	}
}
