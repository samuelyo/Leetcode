package com.leetcode.ReverseLinkedList;

public class ReverseLinkedList5 {

	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		
		ListNode res = reverseList(node1);
		
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode reverseList(ListNode head) {
		
		if(head == null || head.next == null){
			return head;
		}
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode cur = head.next;
		head.next = null;
		ListNode next;
		while(cur != null){
			next = cur.next;
			cur.next = fakeHead.next;
			fakeHead.next = cur;
			cur = next;
		}
		return fakeHead.next;
		
	}

}
