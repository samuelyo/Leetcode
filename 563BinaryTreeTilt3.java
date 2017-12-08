package com.leetcode.BinaryTreeTilt;

public class BinaryTreeTilt3 {

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

		System.out.println(findTilt(t1));

	}
	
	public static int findTilt(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		int res = 0;
		res = Math.abs(sumOfTreeNodes(root.left) - sumOfTreeNodes(root.right));
		res += findTilt(root.left) + findTilt(root.right);
		return res;
		
	}
	
	public static int sumOfTreeNodes(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		int sum = root.val;
		sum += sumOfTreeNodes(root.left) + sumOfTreeNodes(root.right);
		return sum;
	}

}
