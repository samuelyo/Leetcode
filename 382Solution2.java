package com.leetcode.LinkedListRandomNode;

import java.util.ArrayList;
import java.util.Random;

public class Solution2 {

	private ListNode head;
	private Random rand;

	/** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution2(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

	/** Returns a random node's value. */
	public int getRandom() {
		int k = 1;
		ListNode node = this.head;
//		int res = node.val;
		int i = 0;
		ArrayList<Integer> reservoir = new ArrayList<Integer>();

		while (i < k && node != null) {
			reservoir.add(node.val);
			node = node.next;
			i++;
		}
		i++; // i == k => i == k+1
		while (node != null) {
			if (rand.nextInt(i) < k) {
				reservoir.set(rand.nextInt(k), node.val);
			}
			i++;
			node = node.next;
		}
		return reservoir.get(0);// or return reservoir when k > 1;
		
	}
}
