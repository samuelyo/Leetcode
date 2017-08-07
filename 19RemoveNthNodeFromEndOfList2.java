package com.leetcode.RemoveNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfList2 {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode ans = removeNthFromEnd(node1, 2);
		ListNode cur = ans;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode start = new ListNode(0);
		ListNode slow = start, fast = start;
		slow.next = head;

		// Move fast in front so that the gap between slow and fast becomes n
		for (int i = 1; i <= n + 1; i++) {
			fast = fast.next;
		}
		// Move fast to the end, maintaining the gap
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// Skip the desired node
		slow.next = slow.next.next;
		return start.next;

	}
}
