package com.leetcode.FindLargestValueInEachTreeRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node3r = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		
		root.left = node3;
		root.right = node2;
		node3.left = node5;
		node3.right = node3r;
		node2.right = node9;

		List<Integer> list = largestValues(root);
		for(int i = 0;i<list.size();i++){
			System.out.print(list.get(i) + " ");
		}
	}

	public static List<Integer> largestValues(TreeNode root) {
		
		List<Integer> list = new ArrayList<Integer>();
		if(root == null){
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int times = queue.size();
			int maxValue = Integer.MIN_VALUE;
			for(int i = 0;i<times;i++){
				TreeNode cur = queue.poll();
				maxValue = Math.max(maxValue, cur.val);
				if(cur.left != null){
					queue.add(cur.left);
				}
				if(cur.right != null){
					queue.add(cur.right);
				}
			}
			list.add(maxValue);
		}
		return list;
	}
}
