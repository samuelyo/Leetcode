package com.leetcode.reverselinkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList3 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4};
		ListNode head = buildList(nums);
		ListNode res = reverseList(head);
		ListNode cur = res;
		while(null != cur){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
	
	public static ListNode reverseList(ListNode head){
		
		if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
        
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
