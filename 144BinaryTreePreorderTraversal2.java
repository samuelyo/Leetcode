package com.leetcode.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal2 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
//		root.left = node2;
//		root.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.left = node6;
//		node3.right = node7;
		
		root.right = node2;
		node2.left = node3;
		
//		node3.left = root;
//		root.right = node2;
		
		List<Integer> ans = preorderTraversal(root);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		
		List<Integer> ans = new ArrayList<Integer>();
		if(root == null){
			return ans;
		}
		List<TreeNode> lists = new ArrayList<TreeNode>();
		TreeNode head = root;
		while(lists.size() != 0 || head != null){
			TreeNode cur = head;
			while(cur!= null){
				ans.add(cur.val);
				lists.add(cur);
				cur = cur.left;
			}
			if(lists.size() != 0){
				head = lists.get(lists.size()-1).right;
				lists.remove(lists.size()-1);
			}else{
				head = null;
			}
		}
		return ans;
	}
}
