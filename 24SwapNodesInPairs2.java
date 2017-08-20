package com.leetcode.SwapNodesInPairs;

public class SwapNodesInPairs2 {

	public static void main(String[] args) {

		ListNode node1 = null;
		// ListNode node1 = new ListNode(1);
		// ListNode node2 = new ListNode(2);
		// ListNode node3 = new ListNode(3);
		// ListNode node4 = new ListNode(4);
		// ListNode node5 = new ListNode(5);
		// ListNode node6 = new ListNode(6);

		// node1.next = node2;
		// node2.next = node3;
		// node3.next = node4;
		// node4.next = node5;
		// node5.next = node6;

		ListNode res = swapPairs(node1);

		ListNode cur = res;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode swapPairs(ListNode head) {

		if ((head == null) || (head.next == null))
			return head;
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;

	}

}
