package com.leetcode.NonoverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {

	public static void main(String[] args) {
		
		Interval int1 = new Interval(1,100);
		Interval int2 = new Interval(11,22);
		Interval int3 = new Interval(2,12);
		Interval int4 = new Interval(1,11);
		
		Interval[] intervals = {int1,int2,int3,int4};
		
		System.out.println(eraseOverlapIntervals(intervals));

	}

	public static int eraseOverlapIntervals(Interval[] intervals) {
		
		if(intervals == null || intervals.length == 0){
			return 0;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
		});
		int count = 0;
		int index = 0;
		int end = Integer.MIN_VALUE;
		while(index < intervals.length){
			int start = intervals[index].start;
			if(start >= end){
				count ++;
				end = intervals[index].end;
			}
			index ++;
		}
		return intervals.length - count;
		
	}
}
