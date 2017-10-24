package com.leetcode.MergeTwoSortedLists;

public class MergeTwoSortedLists3 {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		
		int[] nums1 = {2,3,5};
		int[] nums2 = {3,4,5};
		ListNode l1 = buildList(nums1);
		ListNode l2 = buildList(nums2);
		ListNode res = mergeTwoLists(l1, l2);
		while(null != res){
			System.out.print(res.val + " ");
			res = res.next;
		}
		
	}
	
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
		
		ListNode fakeHead = new ListNode(0);
		ListNode l1Index = l1;
		ListNode l2Index = l2;
		ListNode cur = fakeHead;
		while(l1Index != null && l2Index != null) {
			if(l1Index.val <= l2Index.val) {
				cur.next = l1Index;
				l1Index = l1Index.next;
			}else {
				cur.next = l2Index;
				l2Index = l2Index.next;
			}
			cur = cur.next;
		}
		if(l1Index != null) {
			cur.next = l1Index;
		}else if(l2Index != null) {
			cur.next = l2Index;
		}
		return fakeHead.next;
		
	}

	public static ListNode buildList(int[] nums){
		
		ListNode first = null;
		ListNode last = null;
		ListNode newNode = null;
		for(int i = 0;i<nums.length;i++){
			newNode = new ListNode(nums[i]);
			if(null == first){
				first = newNode;
				last = newNode;
			}else{
				last.next = newNode;
				last = newNode;
			}
		}
		return first;
	}
}

