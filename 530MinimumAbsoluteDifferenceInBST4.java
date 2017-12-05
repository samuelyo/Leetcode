package com.leetcode.MinimumAbsoluteDifferenceInBST;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST4 {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		
		node1.right = node3;
		node3.left = node2;
		
		System.out.println(getMinimumDifference(node1));

	}
	
	
	public static int getMinimumDifference(TreeNode root) {
		
		List<Integer> list = new ArrayList<Integer>();
		inOrderTraverse(root, list);
		int minDiff = Integer.MAX_VALUE;
		for(int i = 1;i<list.size();i++) {
			minDiff = Math.min(minDiff, list.get(i) - list.get(i - 1));
		}
		return minDiff;
		
	}
	
	public static void inOrderTraverse(TreeNode root, List<Integer> list) {
		
		if(root == null) {
			return ;
		}
		inOrderTraverse(root.left, list);
		list.add(root.val);
		inOrderTraverse(root.right, list);
		
	}
	
}
