package com.leetcode.FlattenNestedListIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.leetcode.MiniParser.NestedInteger;

public class NestedIterator implements Iterator<Integer> {

	Stack<NestedInteger> stack = new Stack<>();

	public NestedIterator(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger curr = stack.peek();
			if (curr.isInteger()) {
				return true;
			}
			stack.pop();
			for (int i = curr.getList().size() - 1; i >= 0; i--) {
				stack.push(curr.getList().get(i));
			}
		}
		return false;
	}
}
