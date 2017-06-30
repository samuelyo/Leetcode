package com.leetcode.ConstructStringFromBinaryTree;

public class ConstructStringFromBinaryTree2 {

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;

		System.out.println(tree2str(node1));

	}

	public static String tree2str(TreeNode t) {

		if (t == null)
			return "";

		String result = t.val + "";

		String left = tree2str(t.left);
		String right = tree2str(t.right);

		if (left == "" && right == "")
			return result;
		if (left == "")
			return result + "()" + "(" + right + ")";
		if (right == "")
			return result + "(" + left + ")";
		return result + "(" + left + ")" + "(" + right + ")";

	}

}
