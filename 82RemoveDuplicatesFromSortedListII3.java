package com.leetcode.RemoveDuplicatesFromSortedListII;

public class RemoveDuplicatesFromSortedListII3 {

	public static void main(String[] args) {
		
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(1);
		ListNode node13 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node11.next = node12;
		node12.next = node13;
		node13.next = node2;
		node2.next = node3;
		
		ListNode res = deleteDuplicates(node11);
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		
		ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
		fakeHead.next = head;
		
		ListNode pre = fakeHead;
		ListNode cur = head;
		while(cur != null) {
			int value = cur.val;
			if(cur.next != null) {
				int next = cur.next.val;
				if(value == next) {
					while(cur != null && cur.val == value) {
						cur = cur.next;
					}
					pre.next = cur;
					continue;
				}
			}
			pre = cur;
			cur = cur.next;
		}
		return fakeHead.next;
		
	}

}
