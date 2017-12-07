package com.leetcode.DiameterofBinaryTree;

public class DiameterofBinaryTree3 {

	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;

		System.out.println(diameterOfBinaryTree(t1));

	}
	
	public static int diameterOfBinaryTree(TreeNode root) {
	
		int res = 0;
		return diameterOfBinaryTreeHelp(root, res);
		
	}
	
	public static int diameterOfBinaryTreeHelp(TreeNode root, int res) {
		
		if(root == null) {
			return res;
		}
		res = Math.max(res, depthOfTree(root.left) + depthOfTree(root.right));
		res = diameterOfBinaryTreeHelp(root.left, res);
		res = diameterOfBinaryTreeHelp(root.right, res);
		return res;
		
	}
	public static int depthOfTree(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(depthOfTree(root.left), depthOfTree(root.right));
	}

}
