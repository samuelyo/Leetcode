package com.leetcode.AverageOfLevelsInBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree2 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		
		root.left = node9;
		root.right = node20;
		node20.left = node15;
		node20.right = node7;
		
		List<Double> list = averageOfLevels(root);
		for(int i = 0;i<list.size();i++){
			System.out.print(list.get(i) + " ");
		}

	}

	public static List<Double> averageOfLevels(TreeNode root) {
		
		List<Double> res = new ArrayList<Double>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0;
			for(int i = 0;i<size;i++) {
				TreeNode cur = queue.poll();
				sum += cur.val;
				if(cur.left != null) {
					queue.add(cur.left);
				}
				if(cur.right != null) {
					queue.add(cur.right);
				}
			}
			res.add(sum / size);
		}
		return res;
		
	}
}
