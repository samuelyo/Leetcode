package com.leetcode.InsertionSortList;

public class InsertionSortList4 {

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
		
//		ListNode node3 = new ListNode(3);
//		ListNode node2 = new ListNode(2);
//		ListNode node1 = new ListNode(1);
//		
//		node3.next = node2;
//		node2.next = node1;
		
		ListNode res = insertionSortList(node4);
		
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode insertionSortList(ListNode head) {
		
		ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		ListNode cur = head;
		while(cur != null) {
			ListNode temp = fakeHead;
			while(temp != cur && temp != null && temp.next != null && temp.next.val <= cur.val) {
				temp = temp.next;
			}
			if(temp != cur) {
				ListNode nextCur = cur.next;
				pre.next = nextCur;
				ListNode nextTemp = temp.next;
				temp.next = cur;
				cur.next = nextTemp;
				cur = nextCur;
			}else {
				pre = cur;
				cur = cur.next;
			}
			
		}
		return fakeHead.next;
		
	}

}
