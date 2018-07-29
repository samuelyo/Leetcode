package com.leetcode.MiddleOfTheLinkedList;

public class MiddleOfTheLinkedList2 {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNode node = build(values);
        ListNode res = middleNode(node);
        ListNode temp = res;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    private static ListNode build(int[] values) {
        ListNode fakeHead = new ListNode(0);
        ListNode pre = fakeHead;
        ListNode newNode;
        for (int value : values) {
            newNode = new ListNode(value);
            pre.next = newNode;
            pre = pre.next;
        }
        return fakeHead.next;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
