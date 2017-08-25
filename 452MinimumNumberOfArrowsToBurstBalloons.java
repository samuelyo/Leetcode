package com.leetcode.MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

	public static void main(String[] args) {
		
		int[][] points = {{10,16},{2,8},{1,6},{7,12}};
		System.out.println(findMinArrowShots(points));

	}

	public static int findMinArrowShots(int[][] points) {
		
		if(points == null || points.length == 0){
			return 0;
		}
		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[1] - o2[1];
			}
		});;
		int count = 0;
		int index = 0;
		int end = Integer.MIN_VALUE;
		while(index < points.length){
			int cur = points[index][0];
			if(cur >= end){
				count ++;
				end = points[index][1];
			}
			while(index < points.length && points[index][0] <= end){
				index ++;
			}
		}
		return count;
		
	}
}
