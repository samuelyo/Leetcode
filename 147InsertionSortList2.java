package com.leetcode.InsertionSortList;

public class InsertionSortList2 {

	public static void main(String[] args) {

		ListNode node4 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node7 = new ListNode(7);
		ListNode node3 = new ListNode(3);

		node4.next = node2;
		node2.next = node5;
		node5.next = node7;
		node7.next = node3;

		ListNode res = insertionSortList(node4);

		ListNode cur = res;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode insertionSortList(ListNode head) {

		if (head == null) {
			return head;
		}

		ListNode helper = new ListNode(0); // new starter of the sorted list
		ListNode cur = head; // the node will be inserted
		ListNode pre = helper; // insert node between pre and pre.next
		ListNode next = null; // the next node will be inserted
		// not the end of input list
		while (cur != null) {
			next = cur.next;
			// find the right place to insert
			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			// insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}

		return helper.next;

	}

}
