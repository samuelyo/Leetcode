package com.leetcode.InsertionSortList;

public class InsertionSortList3 {

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
		ListNode nextNode ;
		while(cur != null){
			if(count == 0){
				nextNode = cur.next;
				cur.next = null;
				fakeHead.next = cur;
				cur = nextNode;
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
			nextNode = cur.next;
			pre.next = cur;
			cur.next = temp;
			cur = nextNode;
			count ++;
		}
		return fakeHead.next;
		
	}

}
