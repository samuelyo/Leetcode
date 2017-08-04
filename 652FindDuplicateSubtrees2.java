package com.leetcode.FindDuplicateSubtrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees2 {

	public static void main(String[] args) {

//		TreeNode node1 = new TreeNode(1);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node21 = new TreeNode(2);
//		TreeNode node41 = new TreeNode(4);
//		TreeNode node42 = new TreeNode(4);
//
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node3.left = node21;
//		node3.right = node41;
//		node21.left = node42;
		
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(1);
		
		root.left = left;
		root.right = right;
		

		List<TreeNode> res = findDuplicateSubtrees(root);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i).val + " ");
		}

	}

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {

		List<TreeNode> res = new LinkedList<TreeNode>();
		postorder(root, new HashMap<String, Integer>(), res);
		return res;
	}

	public static String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
		if (cur == null)
			return "#";
		String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
		if (map.getOrDefault(serial, 0) == 1)
			res.add(cur);
		map.put(serial, map.getOrDefault(serial, 0) + 1);
		return serial;
	}
}
