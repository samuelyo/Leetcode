package com.leetcode.RemoveLinkedListElements;

public class RemoveLinkedListElements4 {

	public static void main(String[] arg){
		
		int[] nums = {1,9,9,9,9,9,9,9,1,9,9,9};
		ListNode head = buildList(nums);
		ListNode res = removeElements(head, 1);
		while(null != res){
			System.out.print(res.val + " ");
			res = res.next;
		}
		
		
	}
	public static ListNode removeElements(ListNode head,int val){
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		ListNode cur = head;
		while(cur != null) {
			if(cur.val == val) {
				pre.next = cur.next;
				cur = pre;
				cur = cur.next;
			}else {
				pre = cur;
				cur = cur.next;
			}
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
