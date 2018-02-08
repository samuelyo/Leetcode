package com.leetcode.OddEvenLinkedList;

public class OddEvenLinkedList3 {

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
		
		ListNode res = oddEvenList(node1);
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode oddEvenList(ListNode head) {
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		
		ListNode cur = head;
		int count = 0;
		ListNode odd = null;
		ListNode even = null;
		ListNode evenStart = null;
		ListNode next;
		
		while(cur != null) {
			count ++;
			if(count == 1) {
				odd = cur;
				cur = cur.next;
				continue;
			}
			if(count == 2) {
				next = cur.next;
				even = cur;
				evenStart = cur;
				cur.next = null;
				cur = next;
				continue;
			}
			if(count % 2 == 1) {
				next = cur.next;
				odd.next = cur;
				cur.next = evenStart;
				odd = cur;
				cur = next;
			}else if(count % 2 == 0) {
				next = cur.next;
				even.next = cur;
				cur.next = null;
				even = cur;
				cur = next;
			}
		}
		return fakeHead.next;
		
	}

}
