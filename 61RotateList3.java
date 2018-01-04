package com.leetcode.RotateList;

public class RotateList3 {

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
		
		ListNode ans = rotateRight(node1, 8);
		ListNode cur = ans;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		
		int len = lenOfList(head);
		if(len == 0) {
			return head;
		}
		k %= len;
		ListNode rev = reverseList(head);
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = rev;
		ListNode cur = rev;
		ListNode pre = fakeHead;
		int count = 0;
		while(count < k) {
			pre = cur;
			cur = cur.next;
			count ++;
		}
		pre.next = null;
		if(cur == rev) {
			return reverseList(cur);
		}else {
			ListNode second = reverseList(cur);
			ListNode first = reverseList(rev);
			ListNode temp = first;
			int index = 0;
			while(index < k - 1) {
				temp = temp.next;
				index ++;
			}
			temp.next = second;
			return first;
		}
		
	}
	
	public static ListNode reverseList(ListNode head) {
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		if(head == null) {
			return null;
		}
		ListNode cur = head.next;
		ListNode pre = head;
		head.next = null;
		ListNode next ;
		while(cur != null) {
			next = cur.next;
			fakeHead.next = cur;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return fakeHead.next;
		
	}
	
	public static int lenOfList(ListNode head) {
		
		int count = 0;
		ListNode cur = head;
		while(cur != null) {
			cur = cur.next;
			count ++;
		}
		return count;
	}

}
