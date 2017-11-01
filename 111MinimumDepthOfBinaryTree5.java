package com.leetcode.MinimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;
		
		System.out.println(minDepth(t1));
		
	}
	
	public static int minDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int level = 0;
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
				if(cur.left == null && cur.right == null) {
					return level + 1;
				}
			}
			level ++;
		}
		return level;
		
	}

}
