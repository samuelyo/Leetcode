package com.leetcode.RemoveNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfList3 {

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
		
		ListNode ans = removeNthFromEnd(node1, 2);
		ListNode cur = ans;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode cur = head;
		int count = 0;
		while(cur != null) {
			cur = cur.next;
			count ++;
		}
		int times = count - n + 1;
		ListNode fHead = new ListNode(0);
		fHead.next = head;
		cur = fHead;
		ListNode pre = fHead;
		int num = 0;
		while(cur != null && num != times) {
			pre = cur;
			cur = cur.next;
			num ++;
		}
		pre.next = cur.next;
		return fHead.next;
	
	}
	
}
