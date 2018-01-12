package com.leetcode.ConstructBinaryTreeFromInorderAndPostorderTraversal;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal3 {

	public static void main(String[] args) {
		
		int[] inorder = {4,2,1,5,3,6};
		int[] postorder = {4,2,5,6,3,1};
		TreeNode treenode = buildTree(inorder,postorder);
		TreeNode.inOrderTraverse(treenode);
		System.out.println();
		TreeNode.postOrderTraverse(treenode);

	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		
		if(inorder.length == 0 || postorder.length == 0) {
			return null;
		}
		if(inorder.length == 1 && postorder.length == 1) {
			return new TreeNode(inorder[0]);
		}
		int rootValue = postorder[postorder.length - 1];
		Integer index = null;
		for(int i = 0;i<inorder.length;i++) {
			if(inorder[i] == rootValue) {
				index = i;
				break;
			}
		}
		int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
		int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
		int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);
		
		TreeNode root = new TreeNode(rootValue);
		root.left = buildTree(inLeft, postLeft);
		root.right = buildTree(inRight, postRight);
		return root;
		
	}

}
