package com.leetcode.SwapNodesInPairs;

public class SwapNodesInPairs {

	public static void main(String[] args) {
		
		ListNode node1 = null;
//		ListNode node1 = new ListNode(1);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(5);
//		ListNode node6 = new ListNode(6);
		
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
		
		ListNode res = swapPairs(node1);
		
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode swapPairs(ListNode head) {
		
		int count = 0;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode prePre = fakeHead;
		ListNode cur = fakeHead;
		ListNode pre = fakeHead;
		while(cur != null){
			count ++;
			if(count >= 2){
				prePre = pre;
			}
			pre = cur;
			cur = cur.next;
			if(cur != null && count % 2 == 0){
				pre.next = null;
				pre.next = cur.next;
				cur.next = pre;
				prePre.next = cur;
				prePre = pre;
				pre = cur;
				cur = cur.next;
			}
		}
		return fakeHead.next;
		
	}

}
