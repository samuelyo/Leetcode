package com.leetcode.LowestCommonAncestorofaBinarySearchTree;

import java.util.Deque;
import java.util.LinkedList;

public class LowestCommonAncestorofaBinarySearchTree3 {

	public static void main(String[] args) {

		// TreeNode t1 = new TreeNode(4);
		// TreeNode t2 = new TreeNode(5);
		// TreeNode t3 = new TreeNode(8);
		// TreeNode t4 = new TreeNode(7);
		// TreeNode t5 = new TreeNode(9);
		// TreeNode t6 = new TreeNode(10);
		//
		// t1.left = t2;
		// t1.right = t3;
		// t2.left = t4;
		// t2.right = t5;
		// t4.left = t6;
		//

		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;

		System.out.println(lowestCommonAncestor(t1, t2, t4).val);
		// System.out.println(isParent(t1, t2, t8).val);
		// System.out.println(parentNode(t1, t1).val);

	}

	/**
	 * pay attention to the description of the situation, it is a BST(Balanced
	 * Search Tree) Just walk down from the whole tree's root as long as both p
	 * and q are in the same subtree (meaning their values are both smaller or
	 * both larger than root's). This walks straight from the root to the LCA,
	 * not looking at the rest of the tree,
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		return (root.val - p.val) * (root.val - q.val) < 1 ? root
				: lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
	}
}
