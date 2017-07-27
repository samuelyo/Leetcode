package com.leetcode.ConvertBSTToGreaterTree;

public class ConvertBSTToGreaterTree {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node13 = new TreeNode(13);
		
		root.left = node2;
		root.right = node13;
		
		TreeNode res = convertBST(root);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);

	}
	
	public static int value = 0;
	
	public static TreeNode convertBST(TreeNode root) {
		
		if(root == null){
			return root;
		}
		convertBST(root.right);
		value += root.val;
		root.val = value;
		convertBST(root.left);
		return root;
		
	}

}
