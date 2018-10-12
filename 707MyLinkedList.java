package com.leetcode.DesignLinkedList;

public class MyLinkedList {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    ListNode head;
    int len;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode temp = findAtIndex(index);
        return temp == null ? -1 : temp.value;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(len, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > len) {
            return;
        } else {
            ListNode node = new ListNode(val);
            if (index == 0) {
                node.next = head;
                head = node;
            } else {
                ListNode pre = findAtIndex(index - 1);
                node.next = pre.next;
                pre.next = node;
            }
            len++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) {
            return;
        } else if (index == 0) {
            head = head.next;
        } else {
            ListNode pre = findAtIndex(index - 1);
            pre.next = pre.next.next;
        }
        len--;
    }

    public ListNode findAtIndex(int index) {
        if (index < 0 || index >= len) {
            return null;
        }
        ListNode cur = head;
        int count = 0;
        while (count < index) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
}
