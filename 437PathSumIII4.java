package com.leetcode.PathSumIII;

import java.util.LinkedList;
import java.util.Queue;

public class PathSumIII4 {

	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(-2);
		TreeNode t3 = new TreeNode(-3);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(-2);
		TreeNode t7 = new TreeNode(-1);
		TreeNode t8 = new TreeNode(-2);
		TreeNode t9 = new TreeNode(1);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t4.left = t7;
		
		System.out.println(pathSum(t1, -1));

	}

	public static int pathSum(TreeNode root, int sum) {
		
		int res = 0;
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			res += pathSumHelp(cur, sum);
			if(cur.left != null) {
				queue.add(cur.left);
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}
		return res;
		
	}
	
	public static int pathSumHelp(TreeNode root, int sum) {
		
		if(root == null) {
			return 0;
		}
		if(sum == root.val) {
			return 1 + pathSumHelp(root.left, sum - root.val) + pathSumHelp(root.right, sum - root.val);
		}
		return pathSumHelp(root.left, sum - root.val) + pathSumHelp(root.right, sum - root.val);
	}
}
