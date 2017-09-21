package com.leetcode.FindMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

	public static PriorityQueue<Integer> minHeap;
	public static PriorityQueue<Integer> maxHeap;

	/** initialize your data structure here. */
	public MedianFinder() {

		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2.compareTo(i1);
			}
		});

	}

	public void addNum(int num) {

		if (num < findMedian()) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}

		if (maxHeap.size() > minHeap.size()) {
			minHeap.add(maxHeap.poll());
		}
		if (minHeap.size() - maxHeap.size() > 1) {
			maxHeap.add(minHeap.poll());
		}

	}

	public double findMedian() {

		if (minHeap.size() == 0 && maxHeap.size() == 0) {
			return 0;
		}

		if (minHeap.size() == maxHeap.size()) {
			return (double) ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
		} else {
			return (double) minHeap.peek();
		}

	}

}
