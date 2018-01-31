package com.leetcode.KthSmallestElementInABST;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST6 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(8);
		TreeNode node4 = new TreeNode(4);
		TreeNode node10 = new TreeNode(10);
		TreeNode node1 = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);
		TreeNode node9 = new TreeNode(9);
		TreeNode node12 = new TreeNode(12);
		
		root.left = node4;
		root.right = node10;
		node4.left = node1;
		node4.right = node5;
		node10.left = node9;
		node10.right = node12;
		
		int k = 4;
		System.out.println(kthSmallest(root, k));

	}
	
	public static int kthSmallest(TreeNode root, int k) {
		
		List<Integer> list = new ArrayList<Integer>();
		inorderTraverse(list, root);
		return list.get(k - 1);
		
	}
	
	public static void inorderTraverse(List<Integer> list, TreeNode root) {
		
		if(root == null) {
			return ;
		}
		inorderTraverse(list, root.left);
		list.add(root.val);
		inorderTraverse(list, root.right);
		
	}

}
