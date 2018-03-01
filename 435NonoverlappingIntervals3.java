package com.leetcode.NonoverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals3 {

	public static void main(String[] args) {
		
		Interval int1 = new Interval(1,2);
		Interval int2 = new Interval(2,3);
//		Interval int3 = new Interval(1,2);
//		Interval int4 = new Interval(1,3);
		
		Interval[] intervals = {int1,int2};
		
		System.out.println(eraseOverlapIntervals(intervals));

	}
	
	public static int eraseOverlapIntervals(Interval[] intervals) {
		
		Arrays.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
			
		});
		
		int start = 0;
		int end = Integer.MIN_VALUE;
		int index = 0;
		int count = 0;
		while(index < intervals.length) {
			Interval cur = intervals[index];
			if(cur.start >= end) {
				count ++;
				start = cur.start;
				end = cur.end;
			}
			index ++;
		}
		return intervals.length - count;
		
		
	}

}
