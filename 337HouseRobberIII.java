package com.leetcode.HouseRobberIII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HouseRobberIII {

	public static void main(String[] args) {
		
//		TreeNode root = new TreeNode(3);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node3r = new TreeNode(3);
//		TreeNode node1 = new TreeNode(1);
//		
//		root.left = node2;
//		root.right = node3;
//		node2.right = node3r;
//		node3.left = node1;
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		
		System.out.println(rob(root));
	}
	
	public static int rob(TreeNode root) {
		
		if(root == null){
			return 0;
		}
		int value = 0;
		if(root.left != null){
			value += rob(root.left.left);
			value += rob(root.left.right);
		}
		if(root.right != null){
			value += rob(root.right.left);
			value += rob(root.right.right);
		}
		return Math.max(root.val + value, rob(root.left) + rob(root.right));
		
	}

}
