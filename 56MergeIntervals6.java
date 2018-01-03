package com.leetcode.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MergeIntervals6 {

	public static void main(String[] args) {

		Interval int4 = new Interval(1, 3);
		Interval int2 = new Interval(7, 6);
		Interval int3 = new Interval(8, 10);
		Interval int1 = new Interval(15, 18);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(int1);
		intervals.add(int2);
		intervals.add(int3);
		intervals.add(int4);
		List<Interval> ans = merge(intervals);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i).start + " " + ans.get(i).end);
		}

	}

	public static List<Interval> merge(List<Interval> intervals) {

		Stack<Interval> stack = new Stack<Interval>();
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		for (Interval it : intervals) {
			if (stack.isEmpty() || it.start > stack.peek().end)
				stack.push(it);
			else {
				stack.peek().end = Math.max(it.end, stack.peek().end);
			}
		}
		return new ArrayList<Interval>(stack);

	}

}
