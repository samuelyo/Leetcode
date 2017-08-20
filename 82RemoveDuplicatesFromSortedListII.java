package com.leetcode.RemoveDuplicatesFromSortedListII;

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node12 = new ListNode(1);
		ListNode node13 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
//		ListNode node32 = new ListNode(3);
//		ListNode node4 = new ListNode(4);
//		ListNode node42 = new ListNode(4);
//		ListNode node5 = new ListNode(5);
		
		node1.next = node12;
		node12.next = node13;
		node13.next = node2;
		node2.next = node3;
//		node3.next = node32;
//		node32.next = node4;
//		node4.next = node42;
//		node42.next = node5;
		
		ListNode res = deleteDuplicates(node1);
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode deleteDuplicates(ListNode head) {
		
		ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
		fakeHead.next = head;
		ListNode cur = head;
		ListNode pre = fakeHead;
		while(cur != null){
			int value = cur.val;
			ListNode temp = cur.next;
			int count = 0;
			while(temp != null && temp.val == value){
				count ++;
				temp = temp.next;
			}
			if(count > 0){
				cur = temp;
				pre.next = temp;
				continue;
			}else{
				pre = cur;
				cur = cur.next;
			}
		}
		return fakeHead.next;
	}
}
