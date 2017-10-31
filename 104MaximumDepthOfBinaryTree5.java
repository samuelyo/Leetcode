package com.leetcode.MaximumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree5 {

	public static void main(String[] args) {
		
		TreeNode p = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(5);
		p.left = p1;
		p.right = p2;
		p1.left = p3;
		p2.right = p4;

		System.out.println(maxDepth(p));


	}

	public static int maxDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0;i<size;i++) {
				TreeNode cur = queue.poll();
				if(cur.left != null) {
					queue.add(cur.left);
				}
				if(cur.right != null) {
					queue.add(cur.right);
				}
			}
			count ++;
		}
		return count;
		
	}
	
	
}
