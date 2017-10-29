package com.leetcode.RemoveDuplicatesFromSortedList;

public class RemoveDuplicatesFromSortedList4 {

	public static void main(String[] args) {
		
		int[] nums = {1,1,2,3,3};
		ListNode numslist = buildList(nums);
		ListNode res = deleteDuplicates(numslist);
		while(null != res){
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {

		if(head == null) {
			return head;
		}
		ListNode cur = head;
		int preValue = head.val;
		while(cur != null) {
			ListNode temp = cur.next;
			while(temp != null && temp.val == preValue) {
				temp = temp.next;
			}
			cur.next = temp;
			if(temp != null) {
				preValue = temp.val;
			}
			cur = temp;
		}
		return head;

	}

	public static ListNode buildList(int[] nums) {

		ListNode first = null;
		ListNode last = null;
		ListNode newNode = null;
		for (int i = 0; i < nums.length; i++) {
			newNode = new ListNode(nums[i]);
			if (null == first) {
				first = newNode;
				last = newNode;
			} else {
				last.next = newNode;
				last = newNode;
			}
		}
		return first;
	}

}
