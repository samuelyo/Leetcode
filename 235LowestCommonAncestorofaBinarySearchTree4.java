package com.leetcode.LowestCommonAncestorofaBinarySearchTree;

public class LowestCommonAncestorofaBinarySearchTree4 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;

		System.out.println(lowestCommonAncestor(t1, t2, t3).val);

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if((root.val - p.val) * (root.val - q.val) <= 0) {
			return root;
		}
		return lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
		
	}
}
