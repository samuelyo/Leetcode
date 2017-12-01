package com.leetcode.Heaters;

import java.util.Arrays;

public class Heaters3 {

	public static void main(String[] args) {
		
		int[] houses = {1,2,3,4};
		int[] heaters = {1,4};
		int res = findRadius(houses, heaters);
		System.out.println(res);

	}
	
	public static int findRadius(int[] houses, int[] heaters) {
	
		Arrays.sort(heaters);
		int res = 0;
		for(Integer h : houses) {
			int index = Arrays.binarySearch(heaters, h);
			if(index < 0) {
				index = -(index + 1);
			}
			int dis1 = index - 1 >= 0 ? h - heaters[index - 1] : Integer.MAX_VALUE;
			int dis2 = index < heaters.length ? heaters[index] - h : Integer.MAX_VALUE;
			res = Math.max(res, Math.min(dis1, dis2));
		}
		return res;
		
	}

}
