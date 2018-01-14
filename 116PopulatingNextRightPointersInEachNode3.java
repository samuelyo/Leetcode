package com.leetcode.PopulatingNextRightPointersInEachNode;

public class PopulatingNextRightPointersInEachNode3 {

	public static void main(String[] args) {
		
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node1 = new TreeLinkNode(2);
		TreeLinkNode node2 = new TreeLinkNode(3);
		TreeLinkNode node3 = new TreeLinkNode(4);
		TreeLinkNode node4 = new TreeLinkNode(5);
		TreeLinkNode node5 = new TreeLinkNode(6);
		TreeLinkNode node6 = new TreeLinkNode(7);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		connect(root);
		System.out.println();

	}
	
	public static void connect(TreeLinkNode root) {
		
		if(root == null) {
			return ;
		}
		if(root.left != null && root.right != null) {
			TreeLinkNode left = root.left;
			TreeLinkNode right = root.right;
			while(left != null && right != null) {
				left.next = right;
				left = left.right;
				right = right.left;
			}
		}
		connect(root.left);
		connect(root.right);
		
	}

}
