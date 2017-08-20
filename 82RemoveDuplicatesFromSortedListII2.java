package com.leetcode.RemoveDuplicatesFromSortedListII;

public class RemoveDuplicatesFromSortedListII2 {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node12 = new ListNode(1);
		ListNode node13 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		// ListNode node32 = new ListNode(3);
		// ListNode node4 = new ListNode(4);
		// ListNode node42 = new ListNode(4);
		// ListNode node5 = new ListNode(5);

		node1.next = node12;
		node12.next = node13;
		node13.next = node2;
		node2.next = node3;
		// node3.next = node32;
		// node32.next = node4;
		// node4.next = node42;
		// node42.next = node5;

		ListNode res = deleteDuplicates(node1);
		ListNode cur = res;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return null;
		ListNode FakeHead = new ListNode(0);
		FakeHead.next = head;
		ListNode pre = FakeHead;
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return FakeHead.next;
	}
}
