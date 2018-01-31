package com.leetcode.KthSmallestElementInABST;

import java.util.Stack;

public class KthSmallestElementInABST7 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(8);
		TreeNode node4 = new TreeNode(4);
		TreeNode node10 = new TreeNode(10);
		TreeNode node1 = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);
		TreeNode node9 = new TreeNode(9);
		TreeNode node12 = new TreeNode(12);
		
		root.left = node4;
		root.right = node10;
		node4.left = node1;
		node4.right = node5;
		node10.left = node9;
		node10.right = node12;
		
		int k = 4;
		System.out.println(kthSmallest(root, k));

	}
	
	public static int kthSmallest(TreeNode root, int k) {
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;

	    while(cur!=null || !stack.empty()){
	        while(cur!=null){
	            stack.add(cur);
	            cur = cur.left;
	        }
	        cur = stack.pop();
	        k --;
	        if(k == 0) {
	        	return cur.val;
	        }
	        cur = cur.right;
	    }
	    return -1;
		
	}

}
