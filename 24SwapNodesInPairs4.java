package com.leetcode.SwapNodesInPairs;

public class SwapNodesInPairs4 {

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
		
		ListNode res = swapPairs(node1);
		
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
	
	public static ListNode swapPairs(ListNode head) {
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		
		ListNode cur = head;
		ListNode pre = fakeHead;
		ListNode next = null;
		while(cur != null) {
			ListNode curNext = cur.next;
			if(curNext == null) {
				break;
			}
			next = curNext.next;
			pre.next = curNext;
			curNext.next = cur;
			cur.next = next;
			pre = cur;
			cur = next;
		}
		return fakeHead.next;
		
	}

}
