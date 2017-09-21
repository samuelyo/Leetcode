package com.leetcode.FindMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder3 {

	private Queue<Integer> small = new PriorityQueue<Integer>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		};
	});

	private Queue<Integer> large = new PriorityQueue<Integer>();

	// Adds a number into the data structure.
	public void addNum(int num) {
		
		large.add(num);
		small.add(large.poll());
		if (large.size() < small.size())
			large.add(small.poll());
	}

	// Returns the median of current data stream
	public double findMedian() {
		
		return large.size() > small.size() ? large.peek() : (large.peek() + small.peek()) / 2.0;
	}
}
