package com.leetcode.RotateList;

public class RotateList {

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
		
		ListNode ans = rotateRight(node1, 0);
		ListNode cur = ans;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		
		if(head == null){
			return null;
		}
		int count = 0;
		ListNode cur = head;
		while(cur != null){
			count ++;
			cur = cur.next;
		}
		k %= count;
		if(k == 0){
			return head;
		}
		ListNode fakeHead = new ListNode(1);
		fakeHead.next = head;
		
		cur = head;
		ListNode fast = head;
		ListNode pre = fakeHead;
		for(int i = 0;i<k;i++){
			fast = fast.next;
		}
		while(fast != null){
			pre = cur;
			fast = fast.next;
			cur = cur.next;
		}
		pre.next = null;
		ListNode temp = cur;
		for(int i = 0;i<k-1;i++){
			temp = temp.next;
		}
		temp.next = fakeHead.next;
		return cur;
		
	}

}
