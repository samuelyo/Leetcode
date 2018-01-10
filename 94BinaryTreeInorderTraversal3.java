package com.leetcode.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BinaryTreeInorderTraversal3 {

	public static List<Integer> ans = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		List<Integer> ans = inorderTraversal(node1);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		
		
		List<Integer> list = new ArrayList<Integer>();
		if(root == null){
			return list;
		}
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    Set<TreeNode> read = new HashSet<TreeNode>();
	    TreeNode cur = root;
	    stack.push(cur);
	    while(!stack.isEmpty()){
	    	while(cur.left != null && !read.contains(cur.left)){
		    	stack.add(cur.left);
		    	cur = cur.left;
		    }
		   TreeNode node = stack.pop();
		   read.add(node);
		   list.add(node.val);
		   if(node.right != null){
			   stack.push(node.right);
			   cur = node.right;
		   }
	    }
	    return list;
		
	}

}
