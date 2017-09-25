package com.leetcode.RecoverBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree2 {

	public static void main(String[] args) {

		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		node5.left = node3;
		node5.right = node4;

		recoverTree(node5);

		List<Integer> res = inOrderTraversal(node5);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static TreeNode firstElement = null;
	public static TreeNode secondElement = null;
	// The reason for this initialization is to avoid null pointer exception in
	// the first comparison when prevElement has not been initialized
	public static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

	public static void recoverTree(TreeNode root) {

		// In order traversal to find the two elements
		traverse(root);

		// Swap the values of the two nodes
		int temp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = temp;
	}

	private static  void traverse(TreeNode root) {

		if (root == null)
			return;

		traverse(root.left);

		// Start of "do some business",
		// If first element has not been found, assign it to prevElement (refer
		// to 6 in the example above)
		if (firstElement == null && prevElement.val >= root.val) {
			firstElement = prevElement;
		}

		// If first element is found, assign the second element to the root
		// (refer to 2 in the example above)
		if (firstElement != null && prevElement.val >= root.val) {
			secondElement = root;
		}
		prevElement = root;

		// End of "do some business"

		traverse(root.right);

	}

	public static List<Integer> inOrderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		list.addAll(inOrderTraversal(root.left));
		list.add(root.val);
		list.addAll(inOrderTraversal(root.right));
		return list;

	}
}
