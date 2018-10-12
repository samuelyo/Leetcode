package com.leetcode.DesignLinkedList;

public class MyLinkedList2 {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    Node head = null;
    private int length = 0;

    public MyLinkedList2() {
    }

    ;

    public int length() {
        return length;
    }

    private Node findAtIndex(int index) {
        if (length == 0 || index > length - 1)
            return null;
        if (index <= 0)
            return head;

        Node result = head.next;
        int idx = 1;
        while (idx < index) {
            result = result.next;
            idx++;
        }
        return result;
    }

    public int get(int index) {
        Node result = findAtIndex(index);
        return result != null ? result.value : -1;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > length)
            return;

        Node nodeAtIndex = findAtIndex(index - 1);
        Node node = new Node(val);
        if (nodeAtIndex == null)
            head = node;
        else if (index == 0) {
            node.next = head;
            head = node;
        } else {
            node.next = nodeAtIndex.next;
            nodeAtIndex.next = node;
        }
        length++;
    }

    public void deleteAtIndex(int index) {
        if (length == 0 || index > length - 1 || index < 0)
            return;

        if (index == 0)
            head = head.next;
        else {
            Node nodeAtIndex = findAtIndex(index - 1);
            if (nodeAtIndex.next != null)
                nodeAtIndex.next = nodeAtIndex.next.next;
        }
        length--;
    }
}
