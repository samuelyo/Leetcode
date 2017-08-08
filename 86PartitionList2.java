package com.leetcode.PartitionList;

public class PartitionList2 {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node22 = new ListNode(2);

		node1.next = node4;
		node4.next = node3;
		node3.next = node2;
		node2.next = node5;
		node5.next = node22;

		ListNode ans = partition(node1, 3);
		ListNode cur = ans;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode partition(ListNode head, int x) {

		ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
		ListNode smaller = smallerHead, bigger = biggerHead;
		while (head != null) {
			if (head.val < x) {
				smaller = smaller.next = head;
			} else {
				bigger = bigger.next = head;
			}
			head = head.next;
		}
		// no need for extra check because of fake heads
		smaller.next = biggerHead.next; // join bigger after smaller
		bigger.next = null; // cut off anything after bigger
		return smallerHead.next;

	}

}
