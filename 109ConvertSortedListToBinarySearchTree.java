package com.leetcode.ConvertSortedListToBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		TreeNode res = sortedListToBST(head);
		TreeNode.inOrderTraverse(res);

	}
	
	public static TreeNode sortedListToBST(ListNode head) {
		
		List<Integer> list = new ArrayList<Integer>();
		ListNode cur = head;
		if(cur == null){
			return null;
		}
		while(cur != null){
			list.add(cur.val);
			cur = cur.next;
		}
		TreeNode root = sortedArrayToBST(list, 0, list.size() - 1);
		return root;
		
	}
	
	public static TreeNode sortedArrayToBST(List<Integer> list, int left, int right) {
		
		if(left > right){
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode node = new TreeNode(list.get(mid));
		node.left = sortedArrayToBST(list, left, mid - 1);
		node.right = sortedArrayToBST(list, mid + 1, right);
		return node;
		
	}

}
