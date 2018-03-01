package com.leetcode.FindRightInterval;

import java.util.TreeMap;

public class FindRightInterval3 {

	public static void main(String[] args) {
		
		Interval i1 = new Interval(1, 4);
		Interval i2 = new Interval(2, 3);
		Interval i3 = new Interval(3, 4);
		
		Interval[] intervals = {i1,i2,i3};
//		Interval[] intervals = {i1};
		int[] res = findRightInterval(intervals);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}

	}
	
	public static int[] findRightInterval(Interval[] intervals) {
		
		int[] res = new int[intervals.length];
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i = intervals.length - 1;i>=0;i--) {
			map.put(intervals[i].start, i);
		}
		for(int i = 0;i<res.length;i++) {
			Interval cur = intervals[i];
			Integer key = map.ceilingKey(cur.end);
			res[i] = key == null ? -1 : map.get(key);
		}
		return res;
		
	}

}
