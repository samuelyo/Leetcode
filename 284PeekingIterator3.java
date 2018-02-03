package com.leetcode.PeekingIterator;

import java.util.Iterator;

public class PeekingIterator3 implements Iterator<Integer>{

	public Iterator<Integer> iter;
	public Integer next;
	
	public PeekingIterator3(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    next = iter.hasNext() ? iter.next() : null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		
		Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
	
}
