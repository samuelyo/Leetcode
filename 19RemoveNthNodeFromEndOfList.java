package com.leetcode.RemoveNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfList {

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
		
		if(head == null){
			return null;
		}
		ListNode fakeHead = new ListNode(1);
		fakeHead.next = head;
		ListNode check ;
		ListNode cur = head;
		ListNode pre = fakeHead;
		while(cur != null){
			check = cur;
			for(int i = 0;i<n;i++){
				check = check.next;
			}
			if(check != null){
				pre = cur;
				cur = cur.next;
			}else{
				pre.next = cur.next;
				break;
			}
		}
		return fakeHead.next;
		
	}
}
