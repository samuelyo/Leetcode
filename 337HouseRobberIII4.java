package com.leetcode.HouseRobberIII;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII4 {

	public static void main(String[] args) {
		
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
		
		if(root == null) {
			return 0;
		}
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		return robHelp(root, map);
		
	}
	
	public static int robHelp(TreeNode root, Map<TreeNode, Integer> map) {
		
		if(map.containsKey(root)) {
			return map.get(root);
		}
		if(root == null) {
			return 0;
		}
		int value = root.val;
		if(root.left != null) {
			value += robHelp(root.left.left, map) + robHelp(root.left.right, map);
		}
		if(root.right != null) {
			value += robHelp(root.right.left, map) + robHelp(root.right.right, map);
		}
		int res =  Math.max(value, robHelp(root.left, map) + robHelp(root.right, map));
		map.put(root, res);
		return res;
		
	}

}
