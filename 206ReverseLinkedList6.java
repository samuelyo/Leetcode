package com.leetcode.ReverseLinkedList;

public class ReverseLinkedList6 {

	public static void main(String[] args) {
		
		int[] nums = {1};
		ListNode node1 = buildList(nums);
		
		ListNode res = reverseList(node1);
		ListNode cur = res;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
	
	public static ListNode reverseList(ListNode head) {
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		if(head == null) {
			return null;
		}
		ListNode cur = head.next;
		ListNode pre = head;
		head.next = null;
		ListNode next ;
		while(cur != null) {
			next = cur.next;
			fakeHead.next = cur;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return fakeHead.next;
		
	}

	public static ListNode buildList(int[] nums){
		ListNode head = null;
		ListNode last = null;
		ListNode newNode = null;
		for(int i = 0;i<nums.length;i++){
			newNode = new ListNode(nums[i]);
			if(head == null){
				head = newNode;
				last = newNode;
			}else{
				last.next = newNode;
				last = newNode;
			}
		}
		return head;
	}
}
