package com.leetcode.LinkedListCycleII;

public class LinkedListCycleII2 {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node3;

		System.out.println(detectCycle(node1).val);

	}

	public static ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null)
			return null;
		ListNode slow = head, fast = head, start = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				while (slow != start) {
					slow = slow.next;
					start = start.next;
				}
				return start;
			}
		}
		return null;

	}

}
