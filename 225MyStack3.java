package com.leetcode.ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack3 {

	Queue<Integer> queue;
	 /** Initialize your data structure here. */
    public MyStack3() {
        queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        for(int i = 0;i<size;i++) {
        	int cur = queue.poll();
        	if(i == size - 1) {
        		return cur;
        	}
        	queue.add(cur);
        }
        return 0;
    }
    
    /** Get the top element. */
    public int top() {
    	int size = queue.size();
        for(int i = 0;i<size;i++) {
        	int cur = queue.poll();
        	queue.add(cur);
        	if(i == size - 1) {
        		return cur;
        	}
        }
        return 0;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
