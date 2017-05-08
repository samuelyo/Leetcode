package com.leetcode.reverselinkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList2 {

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
