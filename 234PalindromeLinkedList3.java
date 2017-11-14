package com.leetcode.PalindromeLinkedList;

public class PalindromeLinkedList3 {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 2, 1, 1 };
		ListNode head = buildList(nums);
		System.out.println(isPalindrome(head));

	}

	public static boolean isPalindrome(ListNode head) {

		ListNode oldHead = null;
		ListNode oldLast = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode curr = new ListNode(cur.val);
			if(oldHead == null) {
				oldHead = curr;
				oldLast = curr;
			}else {
				oldLast.next = curr;
				oldLast = curr;
			}
			cur = cur.next;
		}
		ListNode rev = reverseList(head);
		ListNode old = oldHead;
		cur = rev;
 		while(old != null && cur != null) {
 			if(old.val != cur.val) {
 				return false;
 			}
 			old = old.next;
 			cur = cur.next;
 		}
 		return true;
		
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

	public static ListNode buildList(int[] nums) {

		ListNode head = null;
		ListNode last = null;
		ListNode newNode = null;
		for (int i = 0; i < nums.length; i++) {
			newNode = new ListNode(nums[i]);
			if (head == null) {
				head = newNode;
				last = newNode;
			} else {
				last.next = newNode;
				last = newNode;
			}
		}
		return head;

	}

}
