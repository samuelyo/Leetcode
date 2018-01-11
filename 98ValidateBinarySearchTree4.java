package com.leetcode.ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree4 {

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
		if(list.size() == 0) {
			return true;
		}
		int pre = list.get(0);
		for(int i = 1;i<list.size();i++) {
			int cur = list.get(i);
			if(cur <= pre) {
				return false;
			}
			pre = cur;
		}
		return true;
		
	}
	
	public static void inOrderTraverse(TreeNode root, List<Integer> list) {
		
		if(root == null) {
			return ;
		}
		inOrderTraverse(root.left, list);
		list.add(root.val);
		inOrderTraverse(root.right, list);
		
	}

}
