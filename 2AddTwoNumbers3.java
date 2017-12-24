package com.leetcode.AddTwoNumbers;

public class AddTwoNumbers3 {

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(9);
		ListNode l1Second = new ListNode(9);
		ListNode l1Third = new ListNode(9);
		l1.next = l1Second;
		l1Second.next = l1Third;

		ListNode l2 = new ListNode(9);
		ListNode l2Second = new ListNode(9);
		ListNode l2Third = new ListNode(9);
		l2.next = l2Second;
		l2Second.next = l2Third;

		ListNode ans = addTwoNumbers(l1, l2);

		ListNode cur = ans;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		int extra = 0;
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		while(cur1 != null || cur2 != null) {
			int value1 = cur1 == null ? 0 : cur1.val;
			int value2 = cur2 == null ? 0 : cur2.val;
			int sum = value1 + value2 + extra;
			extra = sum / 10;
			ListNode resNode = new ListNode(sum % 10);
			pre.next = resNode;
			pre = resNode;
			if(cur1 != null) {
				cur1 = cur1.next;
			}
			if(cur2 != null) {
				cur2 = cur2.next;
			}
		}
		if(extra != 0) {
			pre.next = new ListNode(extra);
		}
		return fakeHead.next;
		
	}
}
