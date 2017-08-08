package com.leetcode.PartitionList;

public class PartitionList {

	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node22 = new ListNode(2);
		
		node1.next = node4;
		node4.next = node3;
		node3.next = node2;
		node2.next = node5;
		node5.next = node22;
		
		ListNode ans = partition(node1, 3);
		ListNode cur = ans;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode partition(ListNode head, int x) {
		
		if(head == null){
			return head;
		}
		ListNode fakeHead = new ListNode(1);
		fakeHead.next = head;
		ListNode cur = head;
		ListNode pre = fakeHead;
		ListNode greaterHead = new ListNode(1);
		ListNode greater = greaterHead;
		while(cur != null){
			if(cur.val >= x){
				greater.next = new ListNode(cur.val);
				greater = greater.next;
				pre.next = cur.next;
				cur = pre.next;
			}else{
				pre = cur;
				cur = cur.next;
			}
		}
		pre.next = greaterHead.next;
		return fakeHead.next;
		
	}

}
