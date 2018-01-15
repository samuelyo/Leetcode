package com.leetcode.SumRootToLeafNumbers;

public class SumRootToLeafNumbers3 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		root.left = node2;
		root.right = node3;
		
		System.out.println(sumNumbers(root));
		
	}
	
	public static int sumNumbers(TreeNode root) {
		
		int[] res = new int[1];
		StringBuilder sb = new StringBuilder();
		sumNumbersHelp(root, res, sb);
		return res[0];
		
	}
	
	public static void sumNumbersHelp(TreeNode root, int[] res, StringBuilder sb) {
		
		if(root == null) {
			return ;
		}
		
		if(root.left == null && root.right == null) {
			sb.append(root.val);
			res[0] += Long.valueOf(sb.toString());
			sb.deleteCharAt(sb.length() - 1);
			return ;
		}
		
		sb.append(root.val);
		sumNumbersHelp(root.left, res, sb);
		sumNumbersHelp(root.right, res, sb);
		sb.deleteCharAt(sb.length() - 1);
	}

}
