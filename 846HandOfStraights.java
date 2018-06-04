package com.leetcode.HandOfStraights;

import java.util.TreeMap;

public class HandOfStraights {

	public static void main(String[] args) {

		int[] hand = { 1, 2, 3, 4, 5 };
		int W = 4;
		boolean res = isNStraightHand(hand, W);
		System.out.println(res);

	}

	public static boolean isNStraightHand(int[] hand, int W) {

		if (hand == null || hand.length == 0) {
			return false;
		}
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int num : hand) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		int count = hand.length;
		while (count > 0) {
			Integer min = getMin(map);
			if (min == null) {
				break;
			}
			for (int i = 0; i < W; i++) {
				int key = min + i;
				if (!map.containsKey(key) || map.get(key) == 0) {
					return false;
				} else {
					map.put(key, map.get(key) - 1);
				}
			}
			count -= W;
		}
		return count == 0;
	}

	public static Integer getMin(TreeMap<Integer, Integer> map) {
		Integer min = null;
		while (min == null && map.size() != 0) {
			int minKey = map.firstKey();
			if (map.get(minKey) == 0) {
				map.remove(minKey);
			} else {
				min = minKey;
				break;
			}
		}
		return min;
	}

}
