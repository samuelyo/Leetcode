package com.leetcode.MinimumDepthOfBinaryTree;

public class MinimumDepthOfBinaryTree4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;
		
		System.out.println(minDepth(t1));
		
	}
	
	public static int minDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right != null) {
			return minDepth(root.right) + 1;
		}
		if(root.left != null && root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		
	}

}
