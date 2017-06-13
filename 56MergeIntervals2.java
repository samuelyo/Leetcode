package com.leetcode.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals2 {

	public static void main(String[] args) {
		
		Interval int1 = new Interval(1,3);
		Interval int2 = new Interval(2,6);
		Interval int3 = new Interval(8,10);
		Interval int4 = new Interval(15,18);
//		Interval int5 = new Interval(1,10);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(int1);
		intervals.add(int2);
		intervals.add(int3);
		intervals.add(int4);
//		intervals.add(int5);
		List<Interval> ans = merge(intervals);
		for(int i = 0;i<ans.size();i++){
			System.out.println(ans.get(i).start + " " + ans.get(i).end);
		}

	}

	public static List<Interval> merge(List<Interval> intervals) {
		
		List<Interval> ans = new ArrayList<Interval>();
		if(intervals.size() == 0){
			return ans;
		}
		
		for(int j = 0;j<intervals.size();j++){
			
			Interval cur_old = intervals.get(j);
			int left = cur_old.start;
			int right = cur_old.end;
			if(j == 0){
				ans.add(cur_old);
			}else{
				List<Integer> del = new ArrayList<Integer>();
				for(int i = 0;i<ans.size();i++){
					Interval cur_new = ans.get(i);
					if(cur_new.start >= left && cur_new.end <= right){
						del.add(i);
					}else if(cur_new.start > right || cur_new.end < left){
						continue;
					}else{
						left = Math.min(left, cur_new.start);
						right = Math.max(right, cur_new.end);
						del.add(i);
					}
				}
				Interval newInterval = new Interval(left,right);
				ans.add(newInterval);
				List<Interval> anss = new ArrayList<Interval>();
				for(int i = 0;i<ans.size();i++){
					if(!del.contains(i)){
						anss.add(ans.get(i));
					}
				}
				ans = anss;
			}
			
		}
		
		return ans;
	}
	
}
