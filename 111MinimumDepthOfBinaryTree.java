package com.leetcode.MinimumDepthOfBinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;
		
		System.out.println(minDepth(t1));
		
	}
	
	public static int minDepth(TreeNode root) {
		
		if(null == root){
			return 0;
		}
		int res = 0;
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.push(root);
		res ++;
		TreeNode cur;
		while(!queue.isEmpty()){
			int times = queue.size();
			for(int i = 0;i<times;i++){
				cur = queue.pop();
				if(cur.left != null){
					queue.addLast(cur.left);
				}
				if(cur.right != null){
					queue.addLast(cur.right);
				}
				if(cur.left == null && cur.right == null){
					return res;
				}
			}
			if(queue.size() != 0){
				res ++;
			}
		}
		return res;
	}

}
