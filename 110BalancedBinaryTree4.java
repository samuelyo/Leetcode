package com.leetcode.BalancedBinaryTree;

public class BalancedBinaryTree4 {

	public static void main(String[] args) {
		
		TreeNode p1 = new TreeNode(1);
		TreeNode p2_1 = new TreeNode(2);
		TreeNode p2_2 = new TreeNode(2);
		TreeNode p3_1 = new TreeNode(3);
		TreeNode p3_2 = new TreeNode(3);
		TreeNode p3_3 = new TreeNode(3);
		TreeNode p3_4 = new TreeNode(3);
		TreeNode p4_1 = new TreeNode(4);
		TreeNode p4_2 = new TreeNode(4);
		TreeNode p4_3 = new TreeNode(4);
		TreeNode p4_4 = new TreeNode(4);
		TreeNode p4_5 = new TreeNode(4);
		TreeNode p4_6 = new TreeNode(4);
		TreeNode p5_1 = new TreeNode(5);
		TreeNode p5_2 = new TreeNode(5);
		p1.left = p2_1;
		p1.right = p2_2;
		p2_1.left = p3_1;
		p2_1.right = p3_2;
		p2_2.left = p3_3;
		p2_2.right = p3_4;
		p3_1.left = p4_1;
		p3_1.right = p4_2;
		p3_2.left = p4_3;
		p3_2.right = p4_4;
		p3_3.left = p4_5;
		p3_3.right = p4_6;
		p4_1.left = p5_1;
		p4_2.right = p5_2;
		
		System.out.println(isBalanced(p1));

	}

	public static boolean isBalanced(TreeNode root) {
		
		if(root == null) {
			return true;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if(Math.abs(left - right) <= 1) {
			return isBalanced(root.left) && isBalanced(root.right);
		}else {
			return false;
		}
		
	}
	
	public static int maxDepth(TreeNode node) {
		
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
		
	}
}
