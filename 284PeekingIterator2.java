package com.leetcode.PeekingIterator;

import java.util.Iterator;

public class PeekingIterator2 implements Iterator<Integer> {

	public Integer next = null;
	public Iterator<Integer> iter;
	public boolean done = false;

	public PeekingIterator2(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
		if (iter.hasNext())
			next = iter.next();
		else
			done = true;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		
		Integer result = next;
		if (iter.hasNext()) {
			next = iter.next();
		} else {
			next = null;
			done = true;
		}
		return result;
	}

	@Override
	public boolean hasNext() {
		
		return !done;
	}
}
