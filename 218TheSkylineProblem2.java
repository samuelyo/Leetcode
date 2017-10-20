package com.leetcode.TheSkylineProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem2 {

	public static void main(String[] args) {

		int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
		List<int[]> res = getSkyline(buildings);
		for (int i = 0; i < res.size(); i++) {
			int[] cur = res.get(i);
			for (int j = 0; j < cur.length; j++) {
				System.out.print(cur[j] + " ");
			}
			System.out.println();
		}

	}

	public static List<int[]> getSkyline(int[][] buildings) {

		List<int[]> heights = new ArrayList<>();
		for (int[] b : buildings) {
			heights.add(new int[] { b[0], -b[2] });
			heights.add(new int[] { b[1], b[2] });
		}
		Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
		TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
		heightMap.put(0, 1);
		int prevHeight = 0;
		List<int[]> skyLine = new LinkedList<>();
		for (int[] h : heights) {
			if (h[1] < 0) {
				Integer cnt = heightMap.get(-h[1]);
				cnt = (cnt == null) ? 1 : cnt + 1;
				heightMap.put(-h[1], cnt);
			} else {
				Integer cnt = heightMap.get(h[1]);
				if (cnt == 1) {
					heightMap.remove(h[1]);
				} else {
					heightMap.put(h[1], cnt - 1);
				}
			}
			int currHeight = heightMap.firstKey();
			if (prevHeight != currHeight) {
				skyLine.add(new int[] { h[0], currHeight });
				prevHeight = currHeight;
			}
		}
		return skyLine;
	}

}
