package com.leetcode.MinStack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack4 {

	Stack<Integer> stack;
	PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			if((long)((long)o1 - (long)o2) < Integer.MIN_VALUE) {
				return -1;
			}
			if((long)((long)o1 - (long)o2) > Integer.MAX_VALUE) {
				return 1;
			}
			return o1 - o2;
		}

	});

	/** initialize your data structure here. */
    public MinStack4() {
        stack = new Stack<Integer>();
    }

	public void push(int x) {
		stack.push(x);
		queue.add(x);
	}

	public void pop() {
		int key = this.top();
		stack.pop();
		queue.remove(key);
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return queue.peek();
	}
}
