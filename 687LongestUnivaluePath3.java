package com.leetcode.LongestUnivaluePath;

public class LongestUnivaluePath3 {

	public static void main(String[] args) {
		
		TreeNode node51 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node52 = new TreeNode(5);
		TreeNode node11 = new TreeNode(1);
		TreeNode node12 = new TreeNode(1);
		TreeNode node53 = new TreeNode(5);
		
		node51.left = node4;
		node51.right = node52;
		node4.left = node11;
		node4.right = node12;
		node52.right = node53;
		
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node41 = new TreeNode(4);
//		TreeNode node51 = new TreeNode(5);
//		TreeNode node42 = new TreeNode(4);
//		TreeNode node43 = new TreeNode(4);
//		TreeNode node52 = new TreeNode(5);
//		
//		node1.left = node41;
//		node1.right = node51;
//		node41.left = node42;
//		node41.right = node43;
//		node51.right = node52;
		System.out.println(longestUnivaluePath(node51));

	}
	
	public static int res = 0;
	
	public static int longestUnivaluePath(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		longestUnivaluePathHelper(root);
		return res;
		
	}
	
	public static int longestUnivaluePathHelper(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		int left = longestUnivaluePathHelper(root.left);
		int right = longestUnivaluePathHelper(root.right);
		
		int leftRoot = 0;
		int rightRoot = 0;
		if(root.left != null && root.left.val == root.val) {
			leftRoot = left + 1;
		}
		if(root.right != null && root.right.val == root.val) {
			rightRoot = right + 1;
		}
		res = Math.max(res, leftRoot + rightRoot);
		return Math.max(leftRoot, rightRoot);
		
	}
		
}
