package com.leetcode.SumofLeftLeaves;

public class SumofLeftLeaves5 {

	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(10);
		t1.left = t2;
		t1.right = t3;
		t2.left = t6;
		t3.left = t4;
		t3.right = t5;

		System.out.println(sumOfLeftLeaves(t1));

	}

	public static int sum = 0;
	
	public static int sumOfLeftLeaves(TreeNode root) {

		if(root == null) {
			return sum;
		}
		if(root.left != null) {
			if(root.left.left == null && root.left.right == null) {
				sum += root.left.val;
			}
			sum = sumOfLeftLeaves(root.left);
		}
		sum = sumOfLeftLeaves(root.right);
		return sum;
		
	}
	
}
