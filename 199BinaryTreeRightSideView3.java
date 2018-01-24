package com.leetcode.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView3 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		root.left = node2;
		root.right = node3;
		node3.right = node4;
		node2.right = node5;
		
		List<Integer> res = rightSideView(root);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}

	}
	
	public static List<Integer> rightSideView(TreeNode root) {
		
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int times = queue.size();
			for(int i = 0;i<times;i++) {
				TreeNode cur = queue.poll();
				if(i == times - 1) {
					res.add(cur.val);
				}
				if(cur.left != null) {
					queue.add(cur.left);
				}
				if(cur.right != null) {
					queue.add(cur.right);
				}
			}
		}
		return res;
		
	}

}
