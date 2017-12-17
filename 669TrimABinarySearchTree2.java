package com.leetcode.TrimABinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class TrimABinarySearchTree2 {

	public static void main(String[] args) {
		
		TreeNode node3 = new TreeNode(3);
		TreeNode node0 = new TreeNode(0);
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		
		node3.left = node0;
		node3.right = node4;
		node0.right = node2;
		node2.left = node1;
		
		TreeNode res = trimBST(node3, 1, 3);
		List<Integer> list = new ArrayList<Integer>();
		inOrder(res, list);
		for(int i = 0;i<list.size();i++){
			System.out.print(list.get(i) + " ");
		}
		

	}
	
	public static TreeNode trimBST(TreeNode root, int L, int R) {
		
		if(root == null) {
			return root;
		}
		if(root.val > R) {
			return trimBST(root.left, L, R);
		}else if(root.val < L) {
			return trimBST(root.right, L, R);
		}else {
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
			return root;
		}
		
	}
	
	public static void inOrder(TreeNode root, List<Integer> list) {
		
		if(root == null) {
			return ;
		}
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
		
		
	}

}
