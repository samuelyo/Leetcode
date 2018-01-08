package com.leetcode.PartitionList;

public class PartitionList3 {

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
		
		ListNode first = new ListNode(Integer.MIN_VALUE);
		ListNode firstHead = first;
		ListNode second = new ListNode(Integer.MIN_VALUE);
		ListNode secondHead = second;
		
		ListNode cur = head;
		while(cur != null) {
			if(cur.val < x) {
				first.next = new ListNode(cur.val);
				first = first.next;
			}else {
				second.next = new ListNode(cur.val);
				second = second.next;
			}
			cur = cur.next;
		}
		first.next = secondHead.next;
		return firstHead.next;
		
	}

}
