package com.leetcode.InsertInterval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		
//		Interval i1 = new Interval(1,2);
//		Interval i2 = new Interval(3,5);
//		Interval i3 = new Interval(6,7);
//		Interval i4 = new Interval(8,10);
//		Interval i5 = new Interval(12,16);
		
		Interval i1 = new Interval(1,5);
//		Interval i2 = new Interval(6,9);
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
//		intervals.add(i2);
//		intervals.add(i3);
//		intervals.add(i4);
//		intervals.add(i5);
		
//		Interval newInterval = new Interval(4,9);
		Interval newInterval = new Interval(-1,0);
		List<Interval> res = insert(intervals, newInterval);
		for(int i = 0;i<res.size();i++) {
			System.out.println(res.get(i).start + " " + res.get(i).end);
		}

	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		
		if(intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		int min = intervals.get(0).start;
		int max = intervals.get(intervals.size() - 1).end;		
		int start = newInterval.start;
		int end = newInterval.end;
		if(min > end) {
			intervals.add(0, newInterval);
			return intervals;
		}
		if(max < start) {
			intervals.add(newInterval);
			return intervals;
		}
		Integer startIndex = null;
		Integer endIndex = null;
		Integer newStart = null;
		Integer newEnd = null;
		boolean startIn = false;
		boolean endIn = false;
		for(int i = 0;i<intervals.size();i++) {
			Interval cur = intervals.get(i);
			int curStart = cur.start;
			int curEnd = cur.end;
			if(start >= curStart) {
				if(start > curEnd) {
//					startIndex = i;
					continue;
				}else{
					startIndex = i;
					startIn = true;
					break;
				}
			}else {
				newStart = start;
				startIndex = i;
				break;
			}
		}
		for(int i = intervals.size() - 1;i>=0;i--) {
			Interval cur = intervals.get(i);
			int curStart = cur.start;
			int curEnd = cur.end;
			if(end <= curEnd) {
				if(end < curStart) {
//					endIndex = i;
					continue;
				}else{
					endIndex = i;
					endIn = true;
					break;
				}
			}else {
				newEnd = end;
				endIndex = i;
				break;
			}
		}
		
		Interval temp = null;
		if(startIn && endIn) {
			temp = new Interval(intervals.get(startIndex).start, intervals.get(endIndex).end);
		}else if(startIn && !endIn) {
			temp = new Interval(intervals.get(startIndex).start, end);
		}else if(!startIn && endIn) {
			temp = new Interval(start, intervals.get(endIndex).end);
		}else {
			temp = new Interval(start, end);
		}
		
		List<Interval> res = new ArrayList<Interval>();
		if(startIndex != null) {
			for(int i = 0;i<startIndex;i++) {
				res.add(intervals.get(i));
			}
		}
		res.add(temp);
		if(endIndex != null) {
			for(int i = endIndex + 1;i<intervals.size();i++) {
				res.add(intervals.get(i));
			}
		}
		return res;
		
	}
}
