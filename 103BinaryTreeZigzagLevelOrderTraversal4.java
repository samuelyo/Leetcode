package com.leetcode.BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal4 {

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
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean flag = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0;i<size;i++) {
				TreeNode cur = queue.poll();
				list.add(cur.val);
				if(cur.left != null) {
					queue.add(cur.left);
				}
				if(cur.right != null) {
					queue.add(cur.right);
				}
			}
			if(!flag) {
				Collections.reverse(list);
			}
			res.add(list);
			flag = !flag;
		}
		return res;
		
	}

}
