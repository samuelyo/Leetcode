package com.leetcode.MergeTwoBinaryTrees;

public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		
		t1.left = node3;
		t1.right = node2;
		node3.left = node5;
		
		TreeNode t2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3r = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		
		t2.left = node1;
		t2.right = node3r;
		node1.right = node4;
		node3r.right = node7;

		TreeNode res = mergeTrees(t1, t2);
		System.out.println(res.val);
		System.out.println(res.left.val);
		System.out.println(res.right.val);
		
		
	}
	
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		
		if(t1 == null && t2 == null){
			return null;
		}
		if(t1 != null && t2 == null){
			t1.left = mergeTrees(t1.left, null); 
			t1.right = mergeTrees(t1.right, null);
			return t1;
		}
		if(t1 == null && t2 != null){
			t1 = new TreeNode(t2.val);
			t1.left = mergeTrees(null, t2.left);
			t1.right = mergeTrees(null, t2.right);
			return t1;
		}
		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
		
	}

}
