package com.leetcode.mergetwosortedlists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
public class MergeTwoSortedLists2 {

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
		
		if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
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

