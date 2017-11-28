package com.leetcode.NumberOfBoomerangs;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs3 {

	public static void main(String[] args) {
		
		int[][] points = {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs(points));
		
	}

	public static int numberOfBoomerangs(int[][] points) {

		int res = 0;
		int len = points.length;
		for(int i = 0;i<len;i++) {
			Map<Long, Integer> map = new HashMap<Long, Integer>();
			for(int j = 0;j<len;j++) {
				if(j == i) {
					continue;
				}
				long dis = distanceOfTwoPoints(points, i, j);
				if(map.containsKey(dis)) {
					int value = map.get(dis);
					map.put(dis, value + 1);
				}else {
					map.put(dis, 1);
				}
			}
			for(Long key : map.keySet()) {
				int value = map.get(key);
				res += value * (value - 1);
			}
		}
		return res;
		
	}
	
	public static long distanceOfTwoPoints(int[][] points, int i, int j) {
		
		int[] point1 = points[i];
		int[] point2 = points[j];
		
		return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
	}

}
