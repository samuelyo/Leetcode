package com.leetcode.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals5 {

	public static void main(String[] args) {

		Interval interval1 = new Interval(1, 4);
		Interval interval2 = new Interval(2, 3);
//		Interval interval3 = new Interval(5, 7);
//		Interval interval4 = new Interval(3, 4);
//		Interval interval5 = new Interval(1, 10);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(interval1);
		intervals.add(interval2);
//		intervals.add(interval3);
//		intervals.add(interval4);
//		intervals.add(interval5);
		List<Interval> ans = merge(intervals);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i).start + " " + ans.get(i).end);
		}

	}

	public static List<Interval> merge(List<Interval> intervals) {

		List<Interval> res = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0) {
			return res;
		}
		res.add(intervals.get(0));
		for(int i = 1;i<intervals.size();i++) {
			Interval cur = intervals.get(i);
			List<Integer> del = new ArrayList<Integer>();
			int left = cur.start;
			int right = cur.end;
			for(int j = 0;j<res.size();j++) {
				Interval temp = res.get(j);
				if(temp.start >= left && temp.end <= right) {
					del.add(j);
				}else if(temp.start > right || temp.end < left) {
					continue;
				}else {
					left = Math.min(left, temp.start);
					right = Math.max(right, temp.end);
					del.add(j);
				}
			}
			List<Interval> newRes = new ArrayList<Interval>();
			newRes.add(new Interval(left, right));
			for(int j = 0;j<res.size();j++) {
				if(!del.contains(j)) {
					newRes.add(res.get(j));
				}
			}
			res = newRes;
		}
		return res;
		
	}

}
