package com.leetcode.ReverseLinkedList;

public class ReverseLinkedList4 {

	public static void main(String[] args) {
		
		int[] nums = {1,1,2,1};
		ListNode head = buildList(nums);
		ListNode res = reverseList(head);
		ListNode cur = res;
		while(null != cur){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
	
	public static ListNode reverseList(ListNode head){
		
		ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
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
