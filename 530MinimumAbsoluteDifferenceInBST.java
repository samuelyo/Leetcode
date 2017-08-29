package com.leetcode.MinimumAbsoluteDifferenceInBST;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		
		node1.right = node3;
		node3.left = node2;
		
		System.out.println(getMinimumDifference(node1));

	}
	
	public static int getMinimumDifference(TreeNode root) {
		
		List<Integer> list = inOrder(root);
		int diff = Integer.MAX_VALUE;
		for(int i = 1;i<list.size();i++){
			diff = Math.min(diff, list.get(i) - list.get(i - 1));
		}
		return diff;
		
	}
	
	public static List<Integer> inOrder(TreeNode root) {
		
		List<Integer> list = new ArrayList<Integer>();
		if(root == null){
			return list;
		}
		list.addAll(inOrder(root.left));
		list.add(root.val);
		list.addAll(inOrder(root.right));
		return list;
		
	}

}
