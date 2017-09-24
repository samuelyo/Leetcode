package com.leetcode.ReverseNodesInkGroup;

public class ReverseNodesInkGroup {

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
		
		int k = 3;
		
		ListNode res = reverseKGroup(node1, k);
		ListNode cur = res;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		
		if(head == null) {
			return null;
		}
		ListNode FakeHead = new ListNode(0);
		FakeHead.next = head;
		
		ListNode pre = FakeHead;
		ListNode start = head;
		ListNode cur = start;
		int count = 0;
		while(cur != null) {
			count ++;
			if(count % k == 0) {
				ListNode nextK = start;
				pre.next = cur;
				ListNode next ;
				while(start != cur) {
					next = start.next;
					start.next = cur.next;
					cur.next = start;
					start = next;
				}
				cur = nextK;
				pre = nextK;
				start = cur.next;
			}
			cur = cur.next;
		}
		return FakeHead.next;
		
	}

}
