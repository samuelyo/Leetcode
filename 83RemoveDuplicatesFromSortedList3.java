package com.leetcode.removeduplicatesfromsortedlist;

public class RemoveDuplicatesFromSortedList3 {

	public static void main(String[] args) {
		
		int[] nums = {1,1};
		ListNode numslist = buildList(nums);
		ListNode res = deleteDuplicates(numslist);
		while(null != res){
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {

		ListNode list = head;

		while (list != null) {
			if (list.next == null) {
				break;
			}
			if (list.val == list.next.val) {
				list.next = list.next.next;
			} else {
				list = list.next;
			}
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
