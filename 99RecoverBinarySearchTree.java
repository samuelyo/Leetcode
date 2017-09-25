package com.leetcode.RecoverBinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		
		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		
		node5.left = node3;
		node5.right = node4;
		
		recoverTree(node5);
		
		List<Integer> res = inOrderTraversal(node5);
		for(int i = 0;i<res.size();i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static void recoverTree(TreeNode root) {
		
		List<Integer> list = inOrderTraversal(root);
		List<Integer> temp = new ArrayList<Integer>(list);
		Collections.sort(temp);
		List<Integer> swap = new ArrayList<Integer>();
		for(int i = 0;i<list.size();i++) {
			if(list.get(i) != temp.get(i)) {
				swap.add(list.get(i));
			}
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			boolean changed = false;
			if(swap.contains(cur.val)) {
				for(int i = 0;i<swap.size();i++) {
					if(!changed && cur.val != swap.get(i)){
						cur.val = swap.get(i);
						changed = !changed;
						count ++;
					}
				}
				if(count == 2) {
					break;
				}
			}
			if(cur != null && cur.left != null) {
				queue.add(cur.left);
			}
			if(cur != null && cur.right != null) {
				queue.add(cur.right);
			}
		}
		
	}
	
	public static List<Integer> inOrderTraversal(TreeNode root) {
		
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) {
			return list;
		}
		list.addAll(inOrderTraversal(root.left));
		list.add(root.val);
		list.addAll(inOrderTraversal(root.right));
		return list;
		
	}
}
