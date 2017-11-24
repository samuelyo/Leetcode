package com.leetcode.SumofLeftLeaves;

import java.util.LinkedList;
import java.util.Queue;

public class SumofLeftLeaves4 {

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

		int sum = 0;
		if(root == null) {
			return sum;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur.left != null) {
				queue.add(cur.left);
				if(cur.left.left == null && cur.left.right == null) {
					sum += cur.left.val;
				}
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}
		return sum;
		
	}
}
