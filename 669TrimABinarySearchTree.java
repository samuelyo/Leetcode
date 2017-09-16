package com.leetcode.TrimABinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class TrimABinarySearchTree {

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
		List<Integer> list = InOrder(res);
		for(int i = 0;i<list.size();i++){
			System.out.print(list.get(i) + " ");
		}
		

	}
	
	public static List<Integer> InOrder(TreeNode root) {
		
		List<Integer> list = new ArrayList<Integer>();
		if(root == null){
			return list;
		}
		list = InOrder(root.left);
		list.add(root.val);
		list.addAll(InOrder(root.right));
		return list;
	}
	
	
	public static TreeNode trimBST(TreeNode root, int L, int R) {
		
		if(root == null){
			return null;
		}
		if(root.val < L){
			return trimBST(root.right, L, R);
		}else if(root.val > R){
			return trimBST(root.left, L, R);
		}else {
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
			return root;
		}
		
	}

}
