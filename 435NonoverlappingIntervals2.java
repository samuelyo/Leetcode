package com.leetcode.NonoverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals2 {

	public static void main(String[] args) {

		Interval int1 = new Interval(1, 100);
		Interval int2 = new Interval(11, 22);
		Interval int3 = new Interval(2, 12);
		Interval int4 = new Interval(1, 11);

		Interval[] intervals = { int1, int2, int3, int4 };

		System.out.println(eraseOverlapIntervals(intervals));

	}

	public static int eraseOverlapIntervals(Interval[] intervals) {

		if (intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new myComparator());
		int end = intervals[0].end;
		int count = 1;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start >= end) {
				end = intervals[i].end;
				count++;
			}
		}
		return intervals.length - count;

	}
}

class myComparator implements Comparator<Interval> {
	public int compare(Interval a, Interval b) {
		return a.end - b.end;
	}
}
