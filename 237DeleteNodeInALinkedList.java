package com.leetcode.deletenodeinalinkedlist;

public class DeleteNodeInALinkedList {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4};
		ListNode head = buildList(nums);
		deleteNode(head);
		printList(head);
		

	}
	
	public static void deleteNode(ListNode node){
		
		node.val = node.next.val;
		node.next = node.next.next;
		
		
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
	
	public static void printList(ListNode head){
		
		ListNode cur = head;
		while(null != cur){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}
