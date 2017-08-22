package com.leetcode.AddTwoNumbersII;

public class AddTwoNumbersII {

	public static void main(String[] args) {
		
		ListNode node7 = new ListNode(7);
		ListNode node2 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		
		node7.next = node2;
		node2.next = node4;
		node4.next = node3;
		
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node42 = new ListNode(4);
		
		node5.next = node6;
		node6.next = node42;
		
		ListNode res = addTwoNumbers(node7, node5);
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode list1 = reverseListNode(l1);
		ListNode list2 = reverseListNode(l2);
		
		ListNode fakeHead = new ListNode(0);
		ListNode resCur = fakeHead;
		ListNode list1Cur = list1;
		ListNode list2Cur = list2;
		int extra = 0;
		
		while(list1Cur != null || list2Cur != null){
			int val1, val2;
			if(list1Cur != null){
				val1 = list1Cur.val;
			}else{
				val1 = 0;
			}
			if(list2Cur != null){
				val2 = list2Cur.val;
			}else{
				val2 = 0;
			}
			int value = val1 + val2 + extra;
			int curVal = value % 10;
			extra = value / 10;
			resCur.next = new ListNode(curVal);
			resCur = resCur.next;
			
			if(list1Cur != null){
				list1Cur = list1Cur.next;
			}
			if(list2Cur != null){
				list2Cur = list2Cur.next;
			}
			
		}
		if(extra != 0){
			resCur.next = new ListNode(extra);
		}
		
		return reverseListNode(fakeHead.next);
	}
	
	public static ListNode reverseListNode(ListNode head) {
		
		if(null == head){
			return null;
		}
		ListNode p = head;
		ListNode q = head.next;
		ListNode r = null;
		p.next = null;
		
		while(null != q){
			
			r = q.next;
			q.next = p;
			p = q;
			q = r;
			
		}
		
		return p;
	}
}
