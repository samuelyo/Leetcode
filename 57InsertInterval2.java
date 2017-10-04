package com.leetcode.InsertInterval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval2 {

	public static void main(String[] args) {

		// Interval i1 = new Interval(1,2);
		// Interval i2 = new Interval(3,5);
		// Interval i3 = new Interval(6,7);
		// Interval i4 = new Interval(8,10);
		// Interval i5 = new Interval(12,16);

		Interval i1 = new Interval(1, 5);
		// Interval i2 = new Interval(6,9);

		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		// intervals.add(i2);
		// intervals.add(i3);
		// intervals.add(i4);
		// intervals.add(i5);

		// Interval newInterval = new Interval(4,9);
		Interval newInterval = new Interval(-1, 0);
		List<Interval> res = insert(intervals, newInterval);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).start + " " + res.get(i).end);
		}

	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new LinkedList<Interval>();
		int i = 0;
		// add all the intervals ending before newInterval starts
		while (i < intervals.size() && intervals.get(i).end < newInterval.start)
			result.add(intervals.get(i++));
		// merge all overlapping intervals to one considering newInterval
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval( // we could mutate newInterval here also
					Math.min(newInterval.start, intervals.get(i).start),
					Math.max(newInterval.end, intervals.get(i).end));
			i++;
		}
		result.add(newInterval); // add the union of intervals we got
		// add all the rest
		while (i < intervals.size())
			result.add(intervals.get(i++));
		return result;

	}
}
