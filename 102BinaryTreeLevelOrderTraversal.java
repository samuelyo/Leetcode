package com.leetcode.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;
		
		List<List<Integer>> res = levelOrder(root);
		for(int i = 0;i<res.size();i++){
			List<Integer> cur = res.get(i);
			for(int j = 0;j<cur.size();j++){
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

//		System.out.println(levelOfTree(root));
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(root == null){
			return ans;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> cur ;
		int sum = 1;
		queue.offer(root);
		while(!queue.isEmpty()){
			cur = new ArrayList<Integer>();
			int count = 0;
			int newSum = 0;
			while(count < sum){
				TreeNode temp = queue.poll();
				if(temp.left != null){
					newSum ++;
					queue.offer(temp.left);
				}
				if(temp.right != null){
					newSum ++;
					queue.offer(temp.right);
				}
				cur.add(temp.val);
				count ++;
			}
			sum = newSum;
			if(cur.size() != 0){
				ans.add(cur);
			}
		}
		return ans;
	}
}
