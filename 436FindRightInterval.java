package com.leetcode.FindRightInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class IntervalHelp implements Comparable<IntervalHelp>{
	
	int value;
	int index;
	
	IntervalHelp(int v, int i){
		value = v;
		index = i;
	}

	@Override
	public int compareTo(IntervalHelp o) {
		
		if(this.value == o.value){
			return this.index - o.index;
		}else{
			return this.value - o.value;
		}
	}

	
	
}
public class FindRightInterval {

	public static void main(String[] args) {
		
		Interval i1 = new Interval(1, 2);
//		Interval i2 = new Interval(2, 3);
//		Interval i3 = new Interval(1, 2);
		
//		Interval[] intervals = {i1,i2,i3};
		Interval[] intervals = {i1};
		int[] res = findRightInterval(intervals);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}
		
	}

	public static int[] findRightInterval(Interval[] intervals) {
		
		int len = intervals.length;
		int[] res = new int[len];
		Arrays.fill(res, -1);
		List<IntervalHelp> list = new ArrayList<IntervalHelp>();
		for(int i = 0;i<len;i++){
			list.add(new IntervalHelp(intervals[i].start, i));
		}
		Collections.sort(list);
		for(int i = 0;i<len;i++){
			int curEnd = intervals[i].end;
			int index = getLarger(list, curEnd);
			if(index >= list.size() || index < 0){
				continue;
			}
			List<IntervalHelp> temp = list.subList(index, list.size());
			for(int j = 0;j<temp.size();i++){
				if(temp.get(j).index != i){
					res[i] = temp.get(j).index;
					break;
				}
			}
		}
		return res;
	}
	
	public static int getLarger(List<IntervalHelp> list, int target) {
		
		int left = 0;
		int right = list.size() - 1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(list.get(mid).value == target){
				return mid;
			}else if(list.get(mid).value < target){
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		return left;
	}
}
