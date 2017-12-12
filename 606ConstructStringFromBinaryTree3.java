package com.leetcode.ConstructStringFromBinaryTree;

public class ConstructStringFromBinaryTree3 {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		node1.left = node2;
		node1.right = node3;
		node2.right = node4;

		System.out.println(tree2str(node1));

	}

	public static String tree2str(TreeNode t) {
		
		StringBuilder sb = new StringBuilder();
		if(t == null) {
			return sb.toString();
		}
		sb.append(t.val);
		String left = tree2str(t.left);
		String right = tree2str(t.right);
		if(left.equals("") && right.equals("")) {
			return sb.toString();
		}else if(!left.equals("") && right.equals("")) {
			sb.append("(" + left + ")");
			return sb.toString();
		}else {
			sb.append("(" + left + ")");
			sb.append("(" + right + ")");
			return sb.toString();
		}
		
	}
}
