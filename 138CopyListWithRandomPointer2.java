package com.leetcode.CopyListWithRandomPointer;

public class CopyListWithRandomPointer2 {

	public static void main(String[] args) {

		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
//		RandomListNode node4 = new RandomListNode(4);
//		RandomListNode node5 = new RandomListNode(5);

		node1.next = node2;
		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;

		node1.random = node3;
//		node2.random = node1;
//		node4.random = node4;

		RandomListNode ans = copyRandomList(node1);
		System.out.println(ans);

	}

	public static RandomListNode copyRandomList(RandomListNode head) {

		RandomListNode iter = head, next;

		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			next = iter.next;

			RandomListNode copy = new RandomListNode(iter.label);
			iter.next = copy;
			copy.next = next;

			iter = next;
		}

		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}

		// Third round: restore the original list, and extract the copy list.
		iter = head;
		RandomListNode pseudoHead = new RandomListNode(0);
		RandomListNode copy, copyIter = pseudoHead;

		while (iter != null) {
			next = iter.next.next;

			// extract the copy
			copy = iter.next;
			copyIter.next = copy;
			copyIter = copy;

			// restore the original list
			iter.next = next;

			iter = next;
		}

		return pseudoHead.next;
	}
}
