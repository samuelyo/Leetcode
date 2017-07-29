package com.leetcode.ConvertSortedListToBinarySearchTree;

public class ConvertSortedListToBinarySearchTree2 {

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

		if (head == null) {
			return null;
		}
		return toBST(head, null);

	}

	public static TreeNode toBST(ListNode head, ListNode tail) {
		ListNode slow = head;
		ListNode fast = head;
		if (head == tail){
			return null;
		}
		
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode thead = new TreeNode(slow.val);
		thead.left = toBST(head, slow);
		thead.right = toBST(slow.next, tail);
		return thead;

	}

}
