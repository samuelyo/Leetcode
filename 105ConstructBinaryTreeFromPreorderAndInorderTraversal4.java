package com.leetcode.ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal4 {

	public static void main(String[] args) {
		
		int[] preorder = {1,2,4,3,5,6};
		int[] inorder = {4,2,1,5,3,6};
		TreeNode treenode = buildTree(preorder, inorder);
		TreeNode.preOrderTraverse(treenode);
		System.out.println();
		TreeNode.inOrderTraverse(treenode);

	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		
		if(preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		if(preorder.length == 1 && inorder.length == 1) {
			return new TreeNode(preorder[0]);
		}
		int rootValue = preorder[0];
		Integer index = null;
		for(int i = 0;i<inorder.length;i++) {
			if(inorder[i] == rootValue) {
				index = i;
				break;
			}
		}
		int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
		int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + index);
		int[] preRight = Arrays.copyOfRange(preorder, 1 + index, preorder.length);
		
		TreeNode root = new TreeNode(rootValue);
		root.left = buildTree(preLeft, inLeft);
		root.right = buildTree(preRight, inRight);
		return root;
		
	}
}
