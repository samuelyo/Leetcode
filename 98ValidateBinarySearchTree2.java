package com.leetcode.ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree2 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);

		root.left = left;
		root.right = right;

		System.out.println(isValidBST(root));

	}

	public static boolean isValidBST(TreeNode root) {

		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
		
	}

	public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {

		if (root == null){
			return true;
		}
		if (root.val >= maxVal || root.val <= minVal){
			return false;
		}
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
		
	}
}
