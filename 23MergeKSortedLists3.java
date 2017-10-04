package com.leetcode.MergeKSortedLists;

import java.util.Arrays;

public class MergeKSortedLists3 {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(2);
		ListNode node2 = null;
		ListNode node3 = new ListNode(-1);

		ListNode[] lists = { node1, node2, node3 };
		ListNode res = mergeKLists(lists);

		ListNode cur = res;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];
		if (lists.length == 2)
			return mergeTwoLists(lists[0], lists[1]);
		return mergeTwoLists(mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)),
				mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length)));

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = null;
		ListNode former = null;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				if (former == null)
					former = l2;
				else
					former.next = l2;
				if (head == null)
					head = former;
				else
					former = former.next;
				l2 = l2.next;
			} else {
				if (former == null)
					former = l1;
				else
					former.next = l1;
				if (head == null)
					head = former;
				else
					former = former.next;
				l1 = l1.next;
			}
		}
		if (l2 != null)
			l1 = l2;
		former.next = l1;
		return head;

	}

}
