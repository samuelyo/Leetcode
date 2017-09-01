package com.leetcode.LinkedListRandomNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int len ;
	public List<Integer> list;
	
	/**
	 * @param head
	 * The linked list's head. Note that the head is guaranteed to be
	 * not null, so it contains at least one node.
	 */
	public Solution(ListNode head) {

		len = 0;
		list = new ArrayList<Integer>();
		ListNode cur = head;
		while(cur != null){
			list.add(cur.val);
			len ++;
			cur = cur.next;
		}
		
	}

	/** Returns a random node's value. */
	public int getRandom() {

		int index = (int) (Math.random() * len);
		return list.get(index);
		
	}
}
