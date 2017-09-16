package com.leetcode.SecondMinimumNodeInABinaryTree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SecondMinimumNodeInABinaryTree2 {

	public static void main(String[] args) {

		TreeNode node21 = new TreeNode(2);
		TreeNode node22 = new TreeNode(2);
		TreeNode node51 = new TreeNode(5);
		TreeNode node52 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);

		node21.left = node22;
		node21.right = node51;
		node51.left = node52;
		node52.right = node7;

		System.out.println(findSecondMinimumValue(node21));

	}

	public static int findSecondMinimumValue(TreeNode root) {

		if (root == null) {
			return -1;
		}
		Set<Integer> set = new TreeSet<>();
		dfs(root, set);
		Iterator<Integer> iterator = set.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			count++;
			int result = iterator.next();
			if (count == 2) {
				return result;
			}
		}
		return -1;
	}

	private static void dfs(TreeNode root, Set<Integer> set) {
		
		if (root == null) {
			return;
		}
		set.add(root.val);
		dfs(root.left, set);
		dfs(root.right, set);
		return;

	}
}
