package com.leetcode.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal4 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		root.right = node2;
		node2.left = node3;
		
		List<Integer> ans = preorderTraversal(root);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}
		
	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
		
		List<Integer> res = new ArrayList<Integer>();
		preOrderHelp(root, res);
		return res;
		
	}
	
	public static void preOrderHelp(TreeNode root, List<Integer> res) {
		
		if(root == null) {
			return ;
		}
		res.add(root.val);
		preOrderHelp(root.left, res);
		preOrderHelp(root.right, res);
		
	}

}
