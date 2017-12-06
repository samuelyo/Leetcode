package com.leetcode.ConvertBSTToGreaterTree;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTToGreaterTree2 {

	public static void main(String[] args) {
		
		TreeNode node5 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node13 = new TreeNode(13);
		
		node5.left = node2;
		node5.right = node13;
		
		TreeNode res = convertBST(node5);
		inOrderTraverse(res);

	}
	
	private static void inOrderTraverse(TreeNode root) {
		
		if(root == null) {
			return ;
		}
		inOrderTraverse(root.left);
		System.out.print(root.val + " ");
		inOrderTraverse(root.right);
		
	}

	public static TreeNode convertBST(TreeNode root) {
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		inOrderTraverse(root, list);
		int sum = 0;
		for(int i = list.size() - 1;i>=0;i--) {
			int value = list.get(i).val;
			list.get(i).val = value + sum;
			sum += value;
		}
		return root;
		
	}
	

	public static void inOrderTraverse(TreeNode root, List<TreeNode> list) {
		
		if(root == null) {
			return ;
		}
		inOrderTraverse(root.left, list);
		list.add(root);
		inOrderTraverse(root.right, list);
		
	}

}
