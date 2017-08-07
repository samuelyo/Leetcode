package com.leetcode.FindRightInterval;

import java.util.TreeMap;

public class FindRightInterval2 {

	public static void main(String[] args) {

		Interval i1 = new Interval(3, 4);
		Interval i2 = new Interval(2, 3);
		Interval i3 = new Interval(1, 2);

		Interval[] intervals = {i1,i2,i3};
		int[] res = findRightInterval(intervals);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int[] findRightInterval(Interval[] intervals) {

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int[] res = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++)
			map.put(intervals[i].start, i);
		for (int i = 0; i < intervals.length; i++) {
			Integer key = map.ceilingKey(intervals[i].end);
			res[i] = key != null ? map.get(key) : -1;
		}
		return res;
	}
}
