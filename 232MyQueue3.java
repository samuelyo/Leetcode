package com.leetcode.ImplementQueueUsingStacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyQueue3 {

	Stack<Integer> stack;
	
	 /** Initialize your data structure here. */
    public MyQueue3() {
     
    	stack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
    	int size = stack.size();
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i = 0;i<size;i++){
    		int cur = stack.pop();
    		list.add(cur);
    	}
    	stack.push(x);
    	for(int i = list.size() - 1;i>=0;i--) {
    		int cur = list.get(i);
    		stack.push(cur);
    	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
    	return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        
    	return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
    	return stack.isEmpty();
    }
    
}
