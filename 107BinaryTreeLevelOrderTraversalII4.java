package com.leetcode.BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII4 {

	public static void main(String[] args) {
		
		TreeNode p = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(5);
		p.left = p1;
		p.right = p2;
		p1.left = p3;
		p2.right = p4;

		System.out.println(levelOrderBottom(p));

	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			for(int i = 0;i<size;i++) {
				TreeNode cur = queue.poll();
				if(cur != null) {
					list.add(cur.val);
					if(cur.left != null) {
						queue.add(cur.left);
					}
					if(cur.right != null) {
						queue.add(cur.right);
					}
				} 
			}
			res.add(list);
		}
		Collections.reverse(res);
		return res;
		
	}

}
