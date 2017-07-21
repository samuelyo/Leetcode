package com.leetcode.BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal2 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);

		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;

		List<List<Integer>> res = zigzagLevelOrder(root);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> cur = res.get(i);
			for (int j = 0; j < cur.size(); j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> sol = new ArrayList<List<Integer>>();
		travel(root, sol, 0);
		return sol;
	}

	private static void travel(TreeNode curr, List<List<Integer>> sol, int level) {
		if (curr == null){
			return;
		}
			
		if (sol.size() <= level) {
			List<Integer> newLevel = new LinkedList<Integer>();
			sol.add(newLevel);
		}

		List<Integer> collection = sol.get(level);
		if (level % 2 == 0){
			collection.add(curr.val);
		}
		else{
			collection.add(0, curr.val);
		}
		
		travel(curr.left, sol, level + 1);
		travel(curr.right, sol, level + 1);
	}

}
