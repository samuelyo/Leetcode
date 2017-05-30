package com.leetcode.BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths5 {

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

		//DFS - Stack
		List<String> list = new ArrayList<String>();
		Stack<TreeNode> sNode = new Stack<TreeNode>();
		Stack<String> sStr = new Stack<String>();

		if (root == null)
			return list;
		sNode.push(root);
		sStr.push("");
		while (!sNode.isEmpty()) {
			TreeNode curNode = sNode.pop();
			String curStr = sStr.pop();

			if (curNode.left == null && curNode.right == null)
				list.add(curStr + curNode.val);
			if (curNode.left != null) {
				sNode.push(curNode.left);
				sStr.push(curStr + curNode.val + "->");
			}
			if (curNode.right != null) {
				sNode.push(curNode.right);
				sStr.push(curStr + curNode.val + "->");
			}
		}
		return list;
	}

}
