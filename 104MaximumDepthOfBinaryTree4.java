package com.leetcode.MaximumDepthOfBinaryTree;

public class MaximumDepthOfBinaryTree4 {

	public static void main(String[] args) {
		
		TreeNode p = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(5);
		p.left = p1;
		p.right = p2;
		p1.left = p3;
		p2.right = p4;

		System.out.println(maxDepth(p));


	}

	public static int maxDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	
}
