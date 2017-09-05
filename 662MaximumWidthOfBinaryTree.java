package com.leetcode.MaximumWidthOfBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node9 = new TreeNode(9);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node3;
		node1.right = node2;
		node3.left = node5;
		node2.right = node9;
		node5.left = node6;
		node9.right = node7;
		
		System.out.println(widthOfBinaryTree(node1));
		
	}
	
	public static int widthOfBinaryTree(TreeNode root) {
		
		if(root == null){
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> index = new LinkedList<Integer>();
		queue.add(root);
		index.add(1);
		int width = Integer.MIN_VALUE;
		while(!queue.isEmpty()){
			int num = queue.size();
			int start = 0;
			int end = 0;
			for(int i = 0;i<num;i++){
				TreeNode cur = queue.poll();
				int curIndex = index.poll();
				if(i == 0){
					start = curIndex; 
				}
				if(i == num - 1){
					end = curIndex;
				}
				if(cur != null){
					if(cur.left != null){
						queue.add(cur.left);
						index.add(curIndex * 2);
					}
					if(cur.right != null){
						queue.add(cur.right);
						index.add(curIndex * 2 + 1);
					}
				}
			}
			width = Math.max(width, end - start + 1);
		}
		return width;
		
	}

}
