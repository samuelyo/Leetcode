package com.leetcode.LinkedListCycleII;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII3 {

	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node3;
		
		System.out.println(detectCycle(node1).val);

	}
	
	public static ListNode detectCycle(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		Set<ListNode> set = new HashSet<ListNode>();
		boolean hasCircle = false;
		while(slow != null && fast != null && fast.next != null) {
			if(!set.contains(slow)) {
				set.add(slow);
			}
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				hasCircle = true;
				break;
			}
		}
		if(!hasCircle) {
			return null;
		}else {
			while(slow != null) {
				if(!set.contains(slow)) {
					set.add(slow);
				}else {
					return slow;
				}
				slow = slow.next;
			}
			return null;
		}
		
	}

}
