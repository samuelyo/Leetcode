package com.leetcode.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals3 {

	public static void main(String[] args) {

		Interval int1 = new Interval(1, 3);
		Interval int2 = new Interval(2, 6);
		Interval int3 = new Interval(8, 10);
		Interval int4 = new Interval(15, 18);
		// Interval int5 = new Interval(1,10);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(int1);
		intervals.add(int2);
		intervals.add(int3);
		intervals.add(int4);
		// intervals.add(int5);
		List<Interval> ans = merge(intervals);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i).start + " " + ans.get(i).end);
		}

	}

	public static List<Interval> merge(List<Interval> intervals) {

		if (intervals.size() <= 1)
			return intervals;

		// Sort by ascending starting point using an anonymous Comparator
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

		List<Interval> result = new ArrayList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval interval : intervals) {
			if (interval.start <= end) // Overlapping intervals, move the end if
										// needed
				end = Math.max(end, interval.end);
			else { // Disjoint intervals, add the previous one and reset bounds
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}

		// Add the last interval
		result.add(new Interval(start, end));
		return result;
	}

}
