package com.leetcode.HouseRobberIII;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII3 {

	public static void main(String[] args) {

		// TreeNode root = new TreeNode(3);
		// TreeNode node2 = new TreeNode(2);
		// TreeNode node3 = new TreeNode(3);
		// TreeNode node3r = new TreeNode(3);
		// TreeNode node1 = new TreeNode(1);
		//
		// root.left = node2;
		// root.right = node3;
		// node2.right = node3r;
		// node3.left = node1;

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
		
		int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	private static int[] robSub(TreeNode root) {
	    if (root == null) return new int[2];
	    
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    int[] res = new int[2];

	    //res[0] means not robbing this node
	    //res[1] means robbing this node
	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];
	    
	    return res;
		
	}

}
