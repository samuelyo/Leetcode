package com.leetcode.SortList;

public class SortList3 {

	public static void main(String[] args) {
		
		ListNode node4 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node7 = new ListNode(7);
		ListNode node3 = new ListNode(3);
		
		node4.next = node2;
		node2.next = node5;
		node5.next = node7;
		node7.next = node3;
		
		ListNode res = sortList(node4);
		
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode sortList(ListNode head) {
		
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode pre = head;
		ListNode fast = head;
		while(slow != null && fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode bef = sortList(head);
		ListNode aft = sortList(slow);
		ListNode fakeHead = new ListNode(0);
		ListNode befNode = bef;
		ListNode aftNode = aft;
		ListNode p = fakeHead;
		while(befNode != null && aftNode != null) {
			if(befNode.val <= aftNode.val) {
				p.next = befNode;
				befNode = befNode.next;
			}else {
				p.next = aftNode;
				aftNode = aftNode.next;
			}
			p = p.next;
		}
		while(befNode != null) {
			p.next = befNode;
			p = p.next;
			befNode = befNode.next;
		}
		while(aftNode != null) {
			p.next = aftNode;
			p = p.next;
			aftNode = aftNode.next;
		}
		return fakeHead.next;
		
	}

}
