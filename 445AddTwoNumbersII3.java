package com.leetcode.AddTwoNumbersII;

public class AddTwoNumbersII3 {

	public static void main(String[] args) {

		ListNode node7 = new ListNode(7);
		ListNode node2 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3);

		node7.next = node2;
		node2.next = node4;
		node4.next = node3;

		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node42 = new ListNode(4);

		node5.next = node6;
		node6.next = node42;

		ListNode res = addTwoNumbers(node7, node5);
		ListNode cur = res;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode n1 = reverseList(l1);
		ListNode n2 = reverseList(l2);
		
		ListNode fakeHead = new ListNode(0);
		ListNode head = fakeHead;
		int extra = 0;
		ListNode curN1 = n1;
		ListNode curN2 = n2;
		while(curN1 != null || curN2 != null) {
			int value1 = curN1 == null ? 0 : curN1.val;
			int value2 = curN2 == null ? 0 : curN2.val;
			int cur = (value1 + value2 + extra) % 10;
			extra = (value1 + value2 + extra) / 10;
			head.next = new ListNode(cur);
			head = head.next;
			if(curN1 != null) {
				curN1 = curN1.next;
			}
			if(curN2 != null) {
				curN2 = curN2.next;
			}
		}
		if(extra != 0) {
			head.next = new ListNode(extra);
		}
		return reverseList(fakeHead.next);
		
	}

	public static ListNode reverseList(ListNode head) {

		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		if (head == null) {
			return null;
		}
		ListNode cur = head.next;
		ListNode pre = head;
		head.next = null;
		ListNode next;
		while (cur != null) {
			next = cur.next;
			fakeHead.next = cur;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return fakeHead.next;

	}

}
