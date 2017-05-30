package com.leetcode.LowestCommonAncestorofaBinarySearchTree;

import java.util.Deque;
import java.util.LinkedList;

public class LowestCommonAncestorofaBinarySearchTree {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(7);
		TreeNode t5 = new TreeNode(9);
		TreeNode t6 = new TreeNode(10);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t4.left = t6;
		 
		
		
		
		
		
		
		
		
		
		
		
		
//		TreeNode t1 = new TreeNode(3);
//		TreeNode t2 = new TreeNode(1);
//		TreeNode t3 = new TreeNode(4);
//		TreeNode t4 = new TreeNode(2);
//		t1.left = t2;
//		t1.right = t3;
//		t2.right = t4;

		System.out.println(lowestCommonAncestor(t1, t2, t6).val);
//		System.out.println(isParent(t1, t2, t8).val);
//		System.out.println(parentNode(t1, t1).val);

	}

	/**
	 * Solution for the commmon situation
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (null == root) {
			return null;
		}
		TreeNode res = null;	
		
		while (res == null) {

			if (root.left == p && root.right == q) {
				return root;
			}
			if (root.left == q && root.right == p) {
				return root;
			}
			if (p == q) {
				return p;
			}
			if (isParent(root, p, q) != null) {
				return isParent(root, p, q);
			}

			p = parentNode(root, p);
			q = parentNode(root, q);
		}

		return res;

	}

	public static TreeNode parentNode(TreeNode root, TreeNode p) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		if (root == p) {
			return root;
		}
		stack.push(root);
		TreeNode cur;
		while (!stack.isEmpty()) {
			int times = stack.size();
			for (int i = 0; i < times; i++) {
				cur = stack.pop();
				if (cur.left != null) {
					stack.addLast(cur.left);
				}
				if (cur.right != null) {
					stack.addLast(cur.right);
				}
				if (cur.left == p) {
					return cur;
				}
				if (cur.right == p) {
					return cur;
				}
			}
		}
		return null;
	}
	
	public static TreeNode isParent(TreeNode root,TreeNode p,TreeNode q){
		
		boolean res_p = false;
		TreeNode p_parent = parentNode(root, p);
		while(p_parent != root){
			if(p_parent == q){
				res_p = true;
				break;
			}else{
				p_parent = parentNode(root, p_parent);
			}
		}
		
		boolean res_q = false;
		TreeNode q_parent = parentNode(root, q);
		while(q_parent != root){
			if(q_parent == p){
				res_q = true;
				break;
			}else{
				q_parent = parentNode(root, q_parent);
			}
		}
		
		if(res_p == true && res_q == false){
			return q;
		}
		if(res_p == false && res_q == true){
			return p;
		}
		if(res_p == true && res_q == true){
			return p;
		}
		return null;
	}
}
