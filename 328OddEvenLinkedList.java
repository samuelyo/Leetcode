package com.leetcode.OddEvenLinkedList;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
//		node4.next = node5;
		
		ListNode res = oddEvenList(node1);
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode oddEvenList(ListNode head) {
		
		if(head == null){
			return null;
		}
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode cur = head;
		ListNode oddEnd = null;
		ListNode evenEnd = null;
		ListNode next = null;
		int count = 1;
		while(cur != null){
			if(count == 1){
				next = cur.next;
				oddEnd = cur;
				cur = next;
				count ++;
				continue;
			}
			if(count == 2){
				next = cur.next;
				evenEnd = cur;
				cur = next;
				evenEnd.next = null;
				count ++;
				continue;
			}
			if(count % 2 == 1){
				next = cur.next;
				cur.next = oddEnd.next;
				oddEnd.next = cur;
				oddEnd = oddEnd.next;
				cur = next;
				count ++;
			}else{
				next = cur.next;
				cur.next = evenEnd.next;
				evenEnd.next = cur;
				evenEnd = evenEnd.next;
				cur = next;
				count ++;
			}	
		}
		return fakeHead.next;
		
	}

}
