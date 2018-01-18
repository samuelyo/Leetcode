package com.leetcode.ReorderList;

public class ReorderList3 {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		reorderList(node1);

		ListNode cur = node1;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static void reorderList(ListNode head) {

		if (head == null) {
			return;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = head;
		while (slow != null && fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode mid = reverseList(slow);
		ListNode bef = head;
		ListNode aft = mid;
		ListNode tail = mid;
 		while(bef != null && aft != null) {
 			ListNode nextBef = bef.next;
 			ListNode nextAft = aft.next;
 			bef.next = aft;
 			aft.next = nextBef;
 			tail = aft;
 			bef = nextBef;
 			aft = nextAft;
 		}
 		if(aft != null) {
 			tail.next = aft;
 		}
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
