package com.leetcode.HouseRobberIII;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII2 {

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
		
		Map<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
		return robHelp(root, map);

	}

	public static int robHelp(TreeNode node,Map<TreeNode,Integer> map) {
		
		if(node == null){
			return 0;
		}
		if(map.containsKey(node)){
			return map.get(node);
		}
		int value = 0;
		if(node.left != null){
			value += robHelp(node.left.left, map);
			value += robHelp(node.left.right, map);
		}
		if(node.right != null){
			value += robHelp(node.right.left, map);
			value += robHelp(node.right.right, map);
		}
		map.put(node, Math.max(node.val + value, robHelp(node.left,map) + robHelp(node.right,map)));
		return map.get(node);
		
	}

}
