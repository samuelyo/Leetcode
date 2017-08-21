package com.leetcode.ReorderList;

public class ReorderList {

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

		if(head == null){
			return ;
		}
		ListNode cur = head;
		int count = 0;
		while(cur != null){
			count ++;
			cur = cur.next;
		}
		int m = count / 2 + 1;
		int n = count;
		
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		cur = head;
		ListNode preHead = fakeHead;
		count = 1;
		while (count != m) {
			preHead = cur;
			cur = cur.next;
			count++;
		}
		ListNode preTail = cur;
		ListNode newHead = cur;
		while (count != n) {
			if (count == m) {
				newHead = cur;
			}
			cur = cur.next;
			preTail.next = cur.next;
			cur.next = newHead;
			preHead.next = cur;
			newHead = cur;
			cur = preTail;
			count++;
		}
		
		
		ListNode tail = head;
		newHead= head;
		int times = 1;
		cur = head;
		while(times != m){
			tail = cur;
			times ++;
			cur = cur.next;
		}
		while(newHead != tail){
			tail.next = cur.next;
			cur.next = newHead.next;
			newHead.next = cur;
			newHead = cur.next;
			cur = tail.next;
		}
	}
	
}
