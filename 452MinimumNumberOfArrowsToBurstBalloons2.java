package com.leetcode.MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons2 {

	public static void main(String[] args) {

		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		System.out.println(findMinArrowShots(points));

	}

	public static int findMinArrowShots(int[][] points) {

		if (points.length == 0) {
			return 0;
		}
		Arrays.sort(points, (a, b) -> a[1] - b[1]);
		int arrowPos = points[0][1];
		int arrowCnt = 1;
		for (int i = 1; i < points.length; i++) {
			if (arrowPos >= points[i][0]) {
				continue;
			}
			arrowCnt++;
			arrowPos = points[i][1];
		}
		return arrowCnt;

	}
}
