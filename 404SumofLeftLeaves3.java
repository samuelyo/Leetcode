package com.leetcode.SumofLeftLeaves;

import java.util.Stack;

public class SumofLeftLeaves3 {

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
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.empty()) {
			TreeNode node = stack.pop();
			if (node.left != null) {
				if (node.left.left == null && node.left.right == null)
					ans += node.left.val;
				else
					stack.push(node.left);
			}
			if (node.right != null) {
//				if (node.right.left != null || node.right.right != null)
					stack.push(node.right);
			}
		}
		return ans;
	}

}
