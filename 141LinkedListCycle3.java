package com.leetcode.LinkedListCycle;

public class LinkedListCycle3 {

	public static boolean hasCycle(ListNode head){
	
		ListNode slow = head;
		ListNode fast = head;
		
		while(slow != null && fast != null && slow.next != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
		
	}
}
