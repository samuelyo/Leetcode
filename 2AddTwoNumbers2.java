package com.leetcode.AddTwoNumbers;

public class AddTwoNumbers2 {

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

		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

}
