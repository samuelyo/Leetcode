package com.leetcode.SumRootToLeafNumbers;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		root.left = node2;
		root.right = node3;
		
		System.out.println(sumNumbers(root));

	}
	
	public static int sumNumbers(TreeNode root) {
		
		int sum = 0;
		StringBuilder cur = new StringBuilder();
		sum = sumNumbersHelp(root, sum, cur);
		return sum;
	}
	
	public static int sumNumbersHelp(TreeNode root, int sum, StringBuilder sb) {
		
		if(root == null){
			return sum;
		}
		sb.append(root.val);
		if(root.left == null && root.right == null){
			sum += Integer.valueOf(sb.toString());
			sb.deleteCharAt(sb.length() - 1);
			return sum;
		}else{
			sum = sumNumbersHelp(root.left, sum, sb);
			sum = sumNumbersHelp(root.right, sum, sb);
			sb.deleteCharAt(sb.length() - 1);
			return sum;
		}
	}

}
