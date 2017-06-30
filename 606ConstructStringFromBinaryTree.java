package com.leetcode.ConstructStringFromBinaryTree;

public class ConstructStringFromBinaryTree {

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

	public static StringBuilder ans;

	public static String tree2str(TreeNode t) {
		
		ans = new StringBuilder();
		tree2strHelp(t, ans);
		return ans.toString();
			
	}

	public static void tree2strHelp(TreeNode t ,StringBuilder s) {
		
		if(t == null){
			 return ;
		}
		s.append(t.val);
		if(t.left != null || (t.left == null && t.right != null)){
			s.append("(");
			tree2strHelp(t.left, s);
			s.append(")");
		}
		if(t.right != null){
			s.append("(");
			tree2strHelp(t.right, s);
			s.append(")");
		}

	}

}
