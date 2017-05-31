package com.leetcode.SumofLeftLeaves;

public class SumofLeftLeaves2 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;

		System.out.println(sumOfLeftLeaves(t1));

	}

	public static int sumOfLeftLeaves(TreeNode root) {

		if (root == null)
			return 0;
		int ans = 0;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null)
				ans += root.left.val;
			else
				ans += sumOfLeftLeaves(root.left);
		}
		ans += sumOfLeftLeaves(root.right);

		return ans;
	}

}
