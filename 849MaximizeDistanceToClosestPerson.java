package com.leetcode.MaximizeDistanceToClosestPerson;

import java.util.ArrayList;
import java.util.List;

public class MaximizeDistanceToClosestPerson {

	public static void main(String[] args) {

		int[] seats = { 1, 0, 0, 0, 1, 0, 1 };
		int res = maxDistToClosest(seats);
		System.out.println(res);

	}

	public static int maxDistToClosest(int[] seats) {
		int max = Integer.MIN_VALUE;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				list.add(i);
			}
		}
		if (list.size() == 0) {
			return 0;
		}
		if (list.size() == 1) {
			return Math.max(Math.abs(list.get(0) - 0), Math.abs(seats.length - 1 - list.get(0)));
		}
		max = Math.max(Math.abs(list.get(0) - 0), max);
		max = Math.max(Math.abs(seats.length - 1 - list.get(list.size() - 1)), max);
		for (int i = 1; i < list.size(); i++) {
			int dis = (list.get(i) - list.get(i - 1)) / 2;
			max = Math.max(max, dis);
		}
		return max;
	}
}
