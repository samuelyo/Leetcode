package com.leetcode.ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		
		root.left = left;
		root.right = right;
		
		System.out.println(isValidBST(root));

	}

	public static boolean isValidBST(TreeNode root) {
		
		List<Integer> list = new ArrayList<Integer>();
		inOrderTraverse(root, list);
		boolean increase = true;
		for(int i = 0;i<list.size()-1;i++){
			if(list.get(i) >= list.get(i+1)){
				increase = false;
				break;
			}
		}
		return increase;
		
	}
	
	public static void inOrderTraverse(TreeNode root, List<Integer> list) {
		
		if(root == null){
			return ;
		}
		inOrderTraverse(root.left, list);
		list.add(root.val);
		inOrderTraverse(root.right, list);
		
	}
}
