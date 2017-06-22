package com.leetcode.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		node1.right = node2;
		node2.left = node3;
		
		List<Integer> ans = inorderTraversal(node1);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		
		List<Integer> ans = new ArrayList<Integer>();
		if(root == null){
			return ans;
		}
		inoderTraversalHelp(root, ans);
		return ans;
		
	}
	
	public static void inoderTraversalHelp(TreeNode root,List<Integer> list){
		
		if(root == null){
			return ;
		}
		inoderTraversalHelp(root.left, list);
		list.add(root.val);
		inoderTraversalHelp(root.right, list);
		
	}

}
