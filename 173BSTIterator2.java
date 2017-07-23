package com.leetcode.BinarySearchTreeIterator;

import java.util.Stack;

public class BSTIterator2 {

	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator2(TreeNode root) {
        pushAll(root);
    }

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.val;
	}

	private void pushAll(TreeNode node) {
		
		while(node != null){
			stack.push(node);
			node = node.left;
		}
	}

}
