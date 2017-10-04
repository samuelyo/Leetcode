package com.leetcode.MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists2 {

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

		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		for (ListNode node : lists)
			if (node != null)
				queue.add(node);

		while (!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;

			if (tail.next != null)
				queue.add(tail.next);
		}
		return dummy.next;
	}

}
