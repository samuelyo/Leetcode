package com.leetcode.InterSectionOfTwoLinkedLists;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists4 {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		Set<ListNode> set = new HashSet<ListNode>();
		ListNode cur = headA;
		while(cur != null) {
			set.add(cur);
			cur = cur.next;
		}
		cur = headB;
		while(cur != null) {
			if(set.contains(cur)) {
				return cur;
			}else {
				set.add(cur);
			}
			cur = cur.next;
		}
		return null;
		
	}
}
