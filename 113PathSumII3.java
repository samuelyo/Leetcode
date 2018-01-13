package com.leetcode.PathSumII;

import java.util.ArrayList;
import java.util.List;

public class PathSumII3 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		TreeNode node4 = new TreeNode(13);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(2);
		TreeNode node8 = new TreeNode(5);
		TreeNode node9 = new TreeNode(1);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left = node8;
		node5.right = node9;
		
//		TreeNode root = new TreeNode(0);
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node2 = new TreeNode(1);
//		
//		root.left = node1;
//		root.right = node2;
		
		
		List<List<Integer>> ans = pathSum(root, 22);
		for(int i = 0;i<ans.size();i++){
			List<Integer> cur = ans.get(i);
			for(int j = 0;j<cur.size();j++){
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		pathSunHelper(res, list, root, sum);
		return res;
		
	}
	
	public static void pathSunHelper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
		
		if(root == null) {
			return ;
		}
		
		if(root != null && root.left == null && root.right == null && root.val == sum) {
			list.add(root.val);
			res.add(new ArrayList<Integer>(list));
			list.remove(list.size() - 1);
			return ;
		}
		
		if(root.left == null && root.right == null) {
			return ;
		}
		
		list.add(root.val);
		pathSunHelper(res, list, root.left, sum - root.val);
		pathSunHelper(res, list, root.right, sum - root.val);
		list.remove(list.size() - 1);
		
	}

}
