package com.leetcode.AddOneRowToTree;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

	public static void main(String[] args) {
		
//		TreeNode root = new TreeNode(4);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node5 = new TreeNode(5);
		
//		root.left = node2;
//		root.right = node6;
//		node2.left = node3;
//		node2.right = node1;
//		node6.left = node5;
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		
		
		
		int v = 5;
		int d = 4;
		
		TreeNode res = addOneRow(root, v, d);
		System.out.println(res.val);
		
	}

	public static TreeNode addOneRow(TreeNode root, int v, int d) {
		
		if(root == null){
			return root;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(d == 1){
			TreeNode newNode = new TreeNode(v);
			newNode.left = root;
			return newNode;
		}
		queue.add(root);
		int level = 1;
		boolean flag = false;
		while(!queue.isEmpty()){
			int times = queue.size();
			for(int i = 0;i<times;i++){
				TreeNode cur = queue.poll();
				if(level == d-1){
					flag = true;
					TreeNode newNode1 = new TreeNode(v);
					TreeNode newNode2 = new TreeNode(v);
					if(cur.left != null){
						newNode1.left = cur.left;
					}
					cur.left = newNode1;
					if(cur.right != null){
						newNode2.right = cur.right;
					}
					cur.right = newNode2;
				}
				if(cur.left != null){
					queue.add(cur.left);
				}
				if(cur.right != null){
					queue.add(cur.right);
				}
			}
			level ++;
			if(flag){
				break;
			}
		}
		return root;
		
	}
}
