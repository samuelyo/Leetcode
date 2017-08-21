package com.leetcode.InsertionSortList;

public class InsertionSortList {

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
		
		ListNode res = insertionSortList(node4);
		
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode insertionSortList(ListNode head) {
		
		if(head == null){
			return null;
		}
		ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
		int count = 0;
		ListNode cur = head;
		ListNode temp ;
		ListNode pre ;
		while(cur != null){
			if(count == 0){
				ListNode newNode = new ListNode(cur.val);
				fakeHead.next = newNode;
				cur = cur.next;
				count ++;
				continue;
			}
			int times = 0;
			pre = fakeHead;
			temp = fakeHead.next;
			while(times < count && temp.val < cur.val){
				pre = temp;
				temp = temp.next;
				times ++;
			}
			ListNode newNode = new ListNode(cur.val);
			pre.next = newNode;
			newNode.next = temp;
			cur = cur.next;
			count ++;
		}
		return fakeHead.next;
		
	}

}
