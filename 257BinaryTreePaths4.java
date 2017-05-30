package com.leetcode.BinaryTreePaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths4 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(-3);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;

		List<String> res = binaryTreePaths(t1);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

	public static List<String> binaryTreePaths(TreeNode root) {

		//BFS - Queue
		List<String> list = new ArrayList<String>();
		Queue<TreeNode> qNode = new LinkedList<TreeNode>();
		Queue<String> qStr = new LinkedList<String>();

		if (root == null)
			return list;
		qNode.add(root);
		qStr.add("");
		while (!qNode.isEmpty()) {
			TreeNode curNode = qNode.remove();
			String curStr = qStr.remove();

			if (curNode.left == null && curNode.right == null)
				list.add(curStr + curNode.val);
			if (curNode.left != null) {
				qNode.add(curNode.left);
				qStr.add(curStr + curNode.val + "->");
			}
			if (curNode.right != null) {
				qNode.add(curNode.right);
				qStr.add(curStr + curNode.val + "->");
			}
		}
		return list;
	}

}
