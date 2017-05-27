package com.leetcode.SameTree;

import java.util.Stack;

public class SameTree3 {

	public static void main(String[] args) {

		TreeNode p = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		p.left = p1;
		p.right = p2;

		TreeNode q = new TreeNode(1);
		TreeNode q1 = new TreeNode(2);
		TreeNode q2 = new TreeNode(3);
		q.left = q1;
		q.right = q2;

		System.out.println(isSameTree(p, q));

	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {

		Stack<TreeNode> stack_p = new Stack<>();
		Stack<TreeNode> stack_q = new Stack<>();
		if (p != null)
			stack_p.push(p);
		if (q != null)
			stack_q.push(q);
		while (!stack_p.isEmpty() && !stack_q.isEmpty()) {
			TreeNode pn = stack_p.pop();
			TreeNode qn = stack_q.pop();
			if (pn.val != qn.val)
				return false;
			if (pn.right != null)
				stack_p.push(pn.right);
			if (qn.right != null)
				stack_q.push(qn.right);
			if (stack_p.size() != stack_q.size())
				return false;
			if (pn.left != null)
				stack_p.push(pn.left);
			if (qn.left != null)
				stack_q.push(qn.left);
			if (stack_p.size() != stack_q.size())
				return false;
		}
		return stack_p.size() == stack_q.size();
	}

}
