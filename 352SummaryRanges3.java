package com.leetcode.DataStreamAsDisjointIntervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class SummaryRanges3 {

	/** Initialize your data structure here. */

	TreeSet<Interval> set;

    public SummaryRanges3() {
        set = new TreeSet<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start == b.start? a.end - b.end: a.start - b.start;
            }
        });
    }

	public void addNum(int val) {
		Interval interval = new Interval(val, val);
		if (set.contains(interval))
			return;
		Interval low = set.lower(interval), high = set.higher(interval);
		// check if this val is a start of some interval
		if (high != null && high.start == val)
			return;
		// merge three intervals 
		if (low != null && low.end + 1 == val && high != null && val + 1 == high.start) {
			low.end = high.end;
			set.remove(high);
		}
		// merge lower and this interval
		else if (low != null && low.end + 1 >= val) {
			low.end = Math.max(low.end, val);
		}
		// merge this and higher interval
		else if (high != null && val + 1 == high.start) {
			high.start = val;
		}
		// insert this interval
		else {
			set.add(interval);
		}
	}

	public List<Interval> getIntervals() {
		return new ArrayList<>(set);
	}

}
