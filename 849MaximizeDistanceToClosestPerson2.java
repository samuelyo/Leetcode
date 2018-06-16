package com.leetcode.MaximizeDistanceToClosestPerson;

public class MaximizeDistanceToClosestPerson2 {

	public static void main(String[] args) {

		int[] seats = { 1, 0, 0, 0, 1, 0, 1 };
		int res = maxDistToClosest(seats);
		System.out.println(res);

	}

	public static int maxDistToClosest(int[] seats) {
		int res = 0, n = seats.length;
		for (int i = 0, zero = 0; i < n; ++i)
			if (seats[i] == 1)
				zero = 0;
			else
				res = Math.max(res, (++zero + 1) / 2);
		for (int i = 0, zero = 0; seats[i] == 0; ++i)
			res = Math.max(res, ++zero);
		for (int i = n - 1, zero = 0; seats[i] == 0; --i)
			res = Math.max(res, ++zero);
		return res;
	}
}
