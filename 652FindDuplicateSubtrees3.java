package com.leetcode.FindDuplicateSubtrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDuplicateSubtrees3 {

	public static void main(String[] args) {

		// TreeNode node1 = new TreeNode(1);
		// TreeNode node2 = new TreeNode(2);
		// TreeNode node3 = new TreeNode(3);
		// TreeNode node4 = new TreeNode(4);
		// TreeNode node21 = new TreeNode(2);
		// TreeNode node41 = new TreeNode(4);
		// TreeNode node42 = new TreeNode(4);
		//
		// node1.left = node2;
		// node1.right = node3;
		// node2.left = node4;
		// node3.left = node21;
		// node3.right = node41;
		// node21.left = node42;

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
		if (root == null)
			return res;
		HashMap<String, Integer> map = new HashMap<>();
		buildKey(root, map, res);
		return res;
	}

	public static String buildKey(TreeNode root, HashMap<String, Integer> map, List<TreeNode> res) {
		if (root == null)
			return "#";
		String key = Integer.toString(root.val) + buildKey(root.left, map, res) + buildKey(root.right, map, res);
		if (map.containsKey(key) && map.get(key) == 1)
			res.add(root);
		map.put(key, map.getOrDefault(key, 0) + 1);
		return key;
	}
}
