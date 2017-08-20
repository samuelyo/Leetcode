package com.leetcode.ReverseLinkedListII;

public class ReverseLinkedListII {

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
		
		int m = 1;
		int n = 5;
		
		ListNode res = reverseBetween(node1, m, n);
		
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode cur = head;
		ListNode preHead = fakeHead;
		int count = 1;
		while(count != m){
			preHead = cur;
			cur = cur.next;
			count ++;
		}
		ListNode preTail = cur;
		ListNode newHead = cur;
		while(count != n){
			if(count == m){
				newHead = cur;
			}
			cur = cur.next;
			preTail.next = cur.next;
			cur.next = newHead;
			preHead.next = cur;
			newHead = cur;
			cur = preTail;
			count ++;
		}
		return fakeHead.next;
		
	}

}
