package com.leetcode.BinaryTreePaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths2 {

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

		List<String> answer = new ArrayList<String>();
		if (root != null)
			searchBT(root, "", answer);
		return answer;
	}

	private static void searchBT(TreeNode root, String path, List<String> answer) {
		if (root.left == null && root.right == null)
			answer.add(path + root.val);
		if (root.left != null)
			searchBT(root.left, path + root.val + "->", answer);
		if (root.right != null)
			searchBT(root.right, path + root.val + "->", answer);
	}

	
}
