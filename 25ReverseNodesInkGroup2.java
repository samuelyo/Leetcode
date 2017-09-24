package com.leetcode.ReverseNodesInkGroup;

public class ReverseNodesInkGroup2 {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		int k = 3;

		ListNode res = reverseKGroup(node1, k);
		ListNode cur = res;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

	public static ListNode reverseKGroup(ListNode head, int k) {

		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) { // find the k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) { // if k+1 node is found
			curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
			// head - head-pointer to direct part,
			// curr - head-pointer to reversed part;
			while (count-- > 0) { // reverse current k-group:
				ListNode tmp = head.next; // tmp - next head in direct part
				head.next = curr; // preappending "direct" head to the reversed
									// list
				curr = head; // move head of reversed part to a new node
				head = tmp; // move "direct" head to the next node in direct
							// part
			}
			head = curr;
		}
		return head;

	}

}
