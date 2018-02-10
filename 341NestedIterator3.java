package com.leetcode.FlattenNestedListIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.leetcode.MiniParser.NestedInteger;

public class NestedIterator3 implements Iterator<Integer> {

	public Stack<NestedInteger> stack = new Stack<NestedInteger>();
	
	public NestedIterator3(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1;i>=0;i--) {
        	stack.push(nestedList.get(i));
        }
    }

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while(!stack.isEmpty()) {
			NestedInteger cur = stack.peek();
			if(cur.isInteger()) {
				return true;
			}else {
				stack.pop();
				List<NestedInteger> list = cur.getList();
				for(int i = list.size() - 1;i>=0;i--) {
					stack.push(list.get(i));
				}
			}
		}
		return false;
	}
}
