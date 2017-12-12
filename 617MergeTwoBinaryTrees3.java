package com.leetcode.MergeTwoBinaryTrees;

public class MergeTwoBinaryTrees3 {

	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		
		t1.left = node3;
		t1.right = node2;
		node3.left = node5;
		
		TreeNode t2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3r = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		
		t2.left = node1;
		t2.right = node3r;
		node1.right = node4;
		node3r.right = node7;

		TreeNode res = mergeTrees(t1, t2);
		inorderTraverse(res);

	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		
		if(t1 == null && t2 == null) {
			return null;
		}
		if(t1 == null || t2 == null) {
			return t1 == null ? t2 : t1;
		}
		TreeNode node = new TreeNode(t1.val + t2.val);
		node.left = mergeTrees(t1.left, t2.left);
		node.right = mergeTrees(t1.right, t2.right);
		return node;
		
	}
	
	public static void inorderTraverse(TreeNode root) {
		
		if(root == null) {
			return ;
		}
		inorderTraverse(root.left);
		System.out.print(root.val + " ");
		inorderTraverse(root.right);
		
	}
}
