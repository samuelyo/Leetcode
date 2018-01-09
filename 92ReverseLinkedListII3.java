package com.leetcode.ReverseLinkedListII;

public class ReverseLinkedListII3 {

	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		int m = 2;
		int n = 3;
		
		ListNode res = reverseBetween(node1, m, n);
		
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		
		ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
		fakeHead.next = head;
		
		ListNode pre = fakeHead;
		ListNode cur = head;
		ListNode bef = null;
		ListNode aft = null;
		
		int count = 0;
		while(cur != null) {
			count ++;
			if(count == m) {
				bef = pre;
			}
			pre = cur;
			cur = cur.next;
			if(count == n) {
				aft = cur;
				break;
			}
		}
		
		cur = bef.next.next;
		ListNode start = bef.next;
		ListNode tail = start;
		ListNode next = null;
		int times = n - m;
		int t = 0;
		while(t < times) {
			next = cur.next;
			bef.next = cur;
			cur.next = start;
			start = cur;
			cur = next;
			t ++;
		}
		tail.next = aft;
		return fakeHead.next;
		
	}
}
