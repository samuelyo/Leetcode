package com.leetcode.MergeKSortedLists;

public class MergeKSortedLists {

	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(2);
		ListNode node2 = null;
		ListNode node3 = new ListNode(-1);
		
		ListNode[] lists = {node1, node2, node3};
		ListNode res = mergeKLists(lists);
		
		ListNode cur = res;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		

	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		
		if(lists.length == 0) {
			return null;
		}
		if(lists.length == 1) {
			return lists[0];
		}
		
		int len = lists.length;
		if(len % 2 == 0) {
			ListNode[] temp = new ListNode[len / 2];
			int index = 0;
			for(int i = 0;i<len;i+=2) {
				temp[index] = merge(lists[i], lists[i+1]);
				index ++;
			}
			return mergeKLists(temp);
		}else {
			ListNode[] temp = new ListNode[len / 2 + 1];
			int index = 0;
			for(int i = 0;i<len-1;i+=2) {
				temp[index] = merge(lists[i], lists[i+1]);
				index ++;
			}
			temp[index] = lists[len - 1];
			return mergeKLists(temp);
		}
	}

	public static ListNode merge(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0), p = l;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}

		if (l1 != null)
			p.next = l1;

		if (l2 != null)
			p.next = l2;

		return l.next;
	}
	
}
