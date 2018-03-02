package com.leetcode.DeleteNodeInABST;

public class DeleteNodeInABST4 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);

		root.left = node3;
		root.right = node6;
		node3.left = node2;
		node3.right = node4;
		node6.right = node7;

		TreeNode res = deleteNode(root, 0);
		
	}

	public static TreeNode deleteNode(TreeNode root, int key) {

		TreeNode fakeHead = new TreeNode(Integer.MAX_VALUE);
		fakeHead.left = root;
		
		TreeNode pre = fakeHead;
		TreeNode cur = root;
		if(cur == null) {
			return null;
		}
		while(cur.val != key) {
			if(cur.val > key) {
				pre = cur;
				cur = cur.left;
				if(cur == null) {
					return fakeHead.left;
				}
			}else {
				pre = cur;
				cur = cur.right;
				if(cur == null) {
					return fakeHead.left;
				}
			}
		}
		if(cur.left == null && cur.right == null) {
			if(cur.val > pre.val) {
				pre.right = null;
			}else {
				pre.left = null;
			}
			return fakeHead.left;
		}
		if(cur.left == null) {
			if(cur.val > pre.val) {
				pre.right = cur.right;
			}else {
				pre.left = cur.right;
			}
			return fakeHead.left;
		}
		if(cur.right == null) {
			if(cur.val > pre.val) {
				pre.right = cur.left;
			}else {
				pre.left = cur.left;
			}
			return fakeHead.left;
		}
		TreeNode right = cur.right;
		TreeNode min = right;
		while(min.left != null) {
			min = min.left;
		}
		cur.val = min.val;
		cur.right = deleteNode(right, min.val);
		return fakeHead.left;
		
	}
	
}
