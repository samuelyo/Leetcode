package com.leetcode.CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer3 {

	public static void main(String[] args) {

		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		node1.random = node3;
		node2.random = node1;
		node4.random = node4;

		RandomListNode ans = copyRandomList(node1);
		System.out.println(ans);

	}

	public static RandomListNode copyRandomList(RandomListNode head) {

		if (head == null)
			return null;

		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		// loop 1. copy all the nodes
		RandomListNode node = head;
		while (node != null) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}

		// loop 2. assign next and random pointers
		node = head;
		while (node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);

	}
}
