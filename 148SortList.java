package com.leetcode.SortList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

	public static void main(String[] args) {
		
		ListNode node4 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node7 = new ListNode(7);
		ListNode node3 = new ListNode(3);
		
		node4.next = node2;
		node2.next = node5;
		node5.next = node7;
		node7.next = node3;
		
		ListNode res = sortList(node4);
		
		ListNode cur = res;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}
	
	public static ListNode sortList(ListNode head) {
		
		if(head == null){
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		ListNode cur = head;
		while(cur != null){
			list.add(cur.val);
			cur = cur.next;
		}
		Collections.sort(list);
		ListNode start = null;
		ListNode end = null;
		for(int i = 0;i<list.size();i++){
			if(i == 0){
				start = new ListNode(list.get(i));
				end = start;
			}else{
				end.next = new ListNode(list.get(i));
				end = end.next;
			}
		}
		return start;
	}

}
