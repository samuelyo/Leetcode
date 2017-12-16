package com.leetcode.TwoSumIVInputIsABST;

import java.util.LinkedList;
import java.util.Queue;

public class TwoSumIVInputIsABST5 {

	public static void main(String[] args) {
		
//		TreeNode node5 = new TreeNode(5);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node7 = new TreeNode(7);
//		
//		node5.left = node3;
//		node5.right = node6;
//		node3.left = node2;
//		node3.right = node4;
//		node6.right = node7;
		
		TreeNode node1 = new TreeNode(1);
		
		
		System.out.println(findTarget(node1, 2));

	}
	
	public static boolean findTarget(TreeNode root, int k) {
		
		if(root == null) {
			return false;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(k - cur.val != cur.val && hasElement(root, k - cur.val)) {
				return true;
			}
			if(cur.left != null) {
				queue.add(cur.left);
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}
		return false;
		
	}
	
	public static boolean hasElement(TreeNode root, int target) {
		
		if(root == null) {
			return false;
		}
		if(root.val == target) {
			return true;
		}
		if(root.val > target) {
			return hasElement(root.left, target);
		}else {
			return hasElement(root.right, target);
		}
		
	}

}
