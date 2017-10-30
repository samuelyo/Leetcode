package com.leetcode.SymmetricTree;

public class SymmetricTree4 {

	public static void main(String[] args) {
		
		TreeNode p = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(2);
		p.left = p1;
		p.right = p2;
		
		TreeNode p3 = new TreeNode(3);
		TreeNode p4 = new TreeNode(4);
		p1.left = p3;
		p1.right = p4;
		p2.left = p4;
		p2.right = p3;
		
		System.out.println(isSymmetric(p));

	}
	
	public static boolean isSymmetric(TreeNode root) {
		
		if(root == null) {
			return true;
		}
		if(root.left == null && root.right == null) {
			return true;
		}
		if(root.left == null || root.right == null) {
			return false;
		}
		if(root.left.val == root.right.val) {
			return isSameTree(root.left, root.right);
		}else {
			return false;
		}
		
		
		
	}
	
	public static boolean isSameTree(TreeNode node1, TreeNode node2) {
		
		if(node1 == null && node2 == null) {
			return true;
		}
		if(node1 == null || node2 == null) {
			return false;
		}
		if(node1.val == node2.val) {
			return isSameTree(node1.left, node2.right) && isSameTree(node1.right, node2.left);
		}else {
			return false;
		}
		
	}

}
