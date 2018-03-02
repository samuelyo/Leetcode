package com.leetcode.AddTwoNumbersII;

import java.util.Stack;

public class AddTwoNumbersII4 {

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

		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		int sum = 0;
		ListNode list = new ListNode(0);
		while (!s1.empty() || !s2.empty()) {
			if (!s1.empty())
				sum += s1.pop();
			if (!s2.empty())
				sum += s2.pop();
			list.val = sum % 10;
			ListNode head = new ListNode(sum / 10);
			head.next = list;
			list = head;
			sum /= 10;
		}

		return list.val == 0 ? list.next : list;
	}
}
