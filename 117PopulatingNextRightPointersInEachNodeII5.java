package com.leetcode.PopulatingNextRightPointersInEachNodeII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII5 {

	public static void main(String[] args) {
		
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
//		TreeLinkNode node6 = new TreeLinkNode(6);
//		TreeLinkNode node7 = new TreeLinkNode(7);
//		TreeLinkNode node8 = new TreeLinkNode(8);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node3.right = node5;
//		node3.right = node6;
//		node4.left = node7;
//		node6.right = node8;
		
		connect(root);
		
	}
	
	public static void connect(TreeLinkNode root) {
		
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		if(root == null) {
			return ;
		}
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
			for(int i = 0;i<size;i++) {
				TreeLinkNode cur = queue.poll();
				list.add(cur);
				if(cur.left != null) {
					queue.add(cur.left);
				}
				if(cur.right != null) {
					queue.add(cur.right);
				}
			}
			for(int i = 0;i<list.size() - 1;i++) {
				TreeLinkNode cur = list.get(i);
				cur.next = list.get(i + 1);
			}
		}
		
	}

}
