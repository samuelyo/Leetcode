package com.leetcode.PathSum;

public class PathSum3 {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		System.out.println(hasPathSum(t, 1));
		

	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		
		if(root == null) {
			return false;
		}
		if(root.val == sum && root.left == null && root.right == null) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		
	}

}
