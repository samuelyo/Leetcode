package com.leetcode.BalancedBinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedBinaryTree3 {

	public static void main(String[] args) {
		
		TreeNode p1 = new TreeNode(1);
		TreeNode p2_1 = new TreeNode(2);
		TreeNode p2_2 = new TreeNode(2);
		TreeNode p3_1 = new TreeNode(3);
		TreeNode p3_2 = new TreeNode(3);
		TreeNode p3_3 = new TreeNode(3);
		TreeNode p3_4 = new TreeNode(3);
		TreeNode p4_1 = new TreeNode(4);
		TreeNode p4_2 = new TreeNode(4);
		TreeNode p4_3 = new TreeNode(4);
		TreeNode p4_4 = new TreeNode(4);
		TreeNode p4_5 = new TreeNode(4);
		TreeNode p4_6 = new TreeNode(4);
		TreeNode p5_1 = new TreeNode(5);
		TreeNode p5_2 = new TreeNode(5);
		p1.left = p2_1;
		p1.right = p2_2;
		p2_1.left = p3_1;
		p2_1.right = p3_2;
		p2_2.left = p3_3;
		p2_2.right = p3_4;
		p3_1.left = p4_1;
		p3_1.right = p4_2;
		p3_2.left = p4_3;
		p3_2.right = p4_4;
		p3_3.left = p4_5;
		p3_3.right = p4_6;
		p4_1.left = p5_1;
		p4_2.right = p5_2;
		
		System.out.println(isBalanced(p1));

	}

	/**
	 * The second method is based on DFS. 
	 * Instead of calling depth() explicitly for each child node, 
	 * we return the height of the current node in DFS recursion. 
	 * When the sub tree of the current node (inclusive) is balanced, 
	 * the function dfsHeight() returns a non-negative value as the height. 
	 * Otherwise -1 is returned. 
	 * According to the leftHeight and rightHeight of the two children, 
	 * the parent node could check if the sub tree
	 * is balanced, and decides its return value.
	 * @param root
	 * @return
	 */
	public static boolean isBalanced(TreeNode root) {
		return dfsHeight(root) != -1;
		
	}

	private static int dfsHeight(TreeNode node) {
		if(null == node){
			return 0;
		}
		int leftHeight = dfsHeight(node.left);
		if(-1 == leftHeight){
			return -1;
		}
		int rightHeight = dfsHeight(node.right);
		if(-1 == rightHeight){
			return -1;
		}
		if(Math.abs(leftHeight - rightHeight) > 1){
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
