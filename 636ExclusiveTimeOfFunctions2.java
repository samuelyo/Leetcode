package com.leetcode.ExclusiveTimeOfFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions2 {

	public static void main(String[] args) {

		int n = 2;
		List<String> logs = new ArrayList<String>();
		logs.add("0:start:0");
//		logs.add("0:start:1");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");
//		logs.add("0:start:2");
//		logs.add("0:end:3");
//		logs.add("0:end:4");
//		logs.add("0:end:5");

		int[] res = exclusiveTime(n, logs);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int[] exclusiveTime(int n, List<String> logs) {

		// separate time to several intervals, add interval to their function
		int[] result = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		int pre = 0;
		// pre means the start of the interval
		for (String log : logs) {
			String[] arr = log.split(":");
			if (arr[1].equals("start")) {
				if (!st.isEmpty())
					result[st.peek()] += Integer.parseInt(arr[2]) - pre;
				// arr[2] is the start of next interval, doesn't belong to
				// current interval.
				st.push(Integer.parseInt(arr[0]));
				pre = Integer.parseInt(arr[2]);
			} else {
				result[st.pop()] += Integer.parseInt(arr[2]) - pre + 1;
				// arr[2] is end of current interval, belong to current
				// interval. That's why we have +1 here
				pre = Integer.parseInt(arr[2]) + 1;
				// pre means the start of next interval, so we need to +1
			}
		}
		return result;
	}

}
