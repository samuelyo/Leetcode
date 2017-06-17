package com.leetcode.ConstructBinaryTreeFromPreorderAndInorderTraversal;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal3 {

	public static void main(String[] args) {

		int[] preorder = { 1, 2, 4, 3, 5, 6 };
		int[] inorder = { 4, 2, 1, 5, 3, 6 };
		TreeNode treenode = buildTree(preorder, inorder);
		TreeNode.preOrderTraverse(treenode);
		System.out.println();
		TreeNode.inOrderTraverse(treenode);

	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {

		return helper(0, preorder.length - 1,0, inorder.length - 1, preorder, inorder);
	}

	public static TreeNode helper(int preStart, int preEnd,int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0; // Index of current root in inorder
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
			}
		}
		root.left = helper(preStart + 1,preStart + inIndex, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preStart + inIndex - inStart + 1, preEnd,inIndex + 1, inEnd, preorder, inorder);
		return root;

	}
}
