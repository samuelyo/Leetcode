package com.leetcode.ConvertSortedListToBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree3 {

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
		while(cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}
		return sortedListToBSTHelper(list, 0, list.size() - 1);
		
	}
	
	public static TreeNode sortedListToBSTHelper(List<Integer> list, int start, int end) {
		
		if(list == null || list.size() == 0 || start > end) {
			return null;
		}
		int mid = (end - start) / 2 + start;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = sortedListToBSTHelper(list, start, mid - 1);
		root.right = sortedListToBSTHelper(list, mid + 1, end);
		return root;
		
	}

}
