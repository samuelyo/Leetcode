package com.leetcode.RotateList;

public class RotateList2 {

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

		ListNode ans = rotateRight(node1, 4);
		ListNode cur = ans;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode rotateRight(ListNode head, int k) {

		if (head == null) {
			return head;
		}

		int len = 1;// number of nodes
		ListNode newH, tail;
		newH = head;
		tail = head;

		while (tail.next != null) {// get the number of nodes in the list
			tail = tail.next;
			len++;
		}
		tail.next = head;

		if ((k %= len) != 0) {
			for (int i = 0; i < len - k; i++) {// the tail node is the (len-k)-th node (1st node is head)
				tail = tail.next;
			}
		}
		newH = tail.next;
		tail.next = null;

		return newH;

	}

}
