package com.leetcode.LinkedListRandomNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution3 {

	List<ListNode> list;
	
	/**
	 * @param head
	 * The linked list's head. Note that the head is guaranteed to be
	 * not null, so it contains at least one node.
	 */
	public Solution3(ListNode head) {
		
		list = new ArrayList<ListNode>();
		ListNode cur = head;
		while(cur != null) {
			list.add(cur);
			cur = cur.next;
		}
		
	}

	/** Returns a random node's value. */
	public int getRandom() {

		int index = new Random().nextInt(list.size());
		return list.get(index).val;
		
	}

}
