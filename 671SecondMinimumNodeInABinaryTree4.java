package com.leetcode.SecondMinimumNodeInABinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class SecondMinimumNodeInABinaryTree4 {

	public static void main(String[] args) {
		
		TreeNode node21 = new TreeNode(2);
		TreeNode node22 = new TreeNode(2);
		TreeNode node51 = new TreeNode(5);
		TreeNode node52 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		
		node21.left = node22;
		node21.right = node51;
		node51.left = node52;
		node52.right = node7;
		
		System.out.println(findSecondMinimumValue(node21));

	}
	
	public static int findSecondMinimumValue(TreeNode root) {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null) {
			return -1;
		}
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			set.add(cur.val);
			if(cur.left != null) {
				queue.add(cur.left);
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}
		if(set.size() < 2) {
			return -1;
		}
		set.pollFirst();
		return set.first();
	}

}
