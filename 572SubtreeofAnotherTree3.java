package com.leetcode.SubtreeofAnotherTree;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeofAnotherTree3 {
	
	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(2);
		TreeNode t10 = new TreeNode(0);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t4.left = t10;
		
		TreeNode t6 = new TreeNode(3);
		TreeNode t7 = new TreeNode(1);
		TreeNode t8 = new TreeNode(2);
		
		t6.left = t7;
		t6.right = t8;
		
		System.out.println(isSubtree(t1, t6));

	}
	
	public static boolean isSubtree(TreeNode s, TreeNode t) {
		
		if(s == null && t == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(s);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur.val == t.val) {
				if(isSameTree(cur, t)) {
					return true;
				}
			}
			if(cur.left != null) {
				queue.add(cur.left);
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}
		return false;
		
	}
	
	public static boolean isSameTree(TreeNode s, TreeNode t) {
		
		if(s == null && t == null) {
			return true;
		}
		if(s == null || t == null) {
			return false;
		}
		if(s.val == t.val) {
			return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
		}
		return false;
		
	}

}
