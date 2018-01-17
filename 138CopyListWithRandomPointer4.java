package com.leetcode.CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer4 {

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
		
		if(head == null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode copyHead = new RandomListNode(head.label);
		map.put(head, copyHead);
		RandomListNode copy = copyHead;
		RandomListNode cur = head.next;
		while(cur != null) {
			RandomListNode temp = new RandomListNode(cur.label);
			copy.next = temp;
			map.put(cur, temp);
			cur = cur.next;
			copy = copy.next;
		}
		cur = head;
		copy = copyHead;
		while(cur != null) {
			if(cur.random != null) {
				copy.random = map.get(cur.random);
			}
			cur = cur.next;
			copy = copy.next;
		}
		return copyHead;
		
	}
}
