package com.leetcode.BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal2 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		root.right = node2;
		node2.left = node3;
		
//		root.left = node2;
//		root.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.left = node6;
//		node3.right = node7;
		
		List<Integer> res = postorderTraversal(root);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}

	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
		
		List<Integer> res = new ArrayList<Integer>();
		List<TreeNode> read = new ArrayList<TreeNode>();
		if(root == null){
			return res;
		}
		TreeNode cur = root;
		TreeNode head = root;
		List<TreeNode> list = new ArrayList<TreeNode>();
		while(head != null || !list.isEmpty()){
			cur = head;
			while(cur != null){
				list.add(cur);
				cur = cur.left;
			}
			if(!list.isEmpty() && list.get(list.size() - 1).right != null && !read.contains(list.get(list.size() - 1).right)){
				head = list.get(list.size() - 1).right;
				read.add(list.get(list.size() - 1).right);
			}else{
				res.add(list.get(list.size() - 1).val);
				list.remove(list.size() - 1);
				head = null;
			}
		}
		return res;
	}

}
