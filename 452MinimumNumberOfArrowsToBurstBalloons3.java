package com.leetcode.MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons3 {

	public static void main(String[] args) {
		
		int[][] points = {{1,2},{3,4},{5,6},{7,8}};
		System.out.println(findMinArrowShots(points));

	}

	public static int findMinArrowShots(int[][] points) {
		
		if(points == null || points.length == 0 || points[0].length == 0) {
			return 0;
		}
		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		int res = 1;
		int end = points[0][1];
		for(int i = 1;i<points.length;i++) {
			if(points[i][0] > end) {
				res ++;
				end = points[i][1];
			}
		}
		return res;
		
	}
}
