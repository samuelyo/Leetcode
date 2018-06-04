package com.leetcode.HandOfStraights;

import java.util.TreeMap;

public class HandOfStraights2 {

	public static void main(String[] args) {

		int[] hand = { 1, 2, 3, 4, 5 };
		int W = 4;
		boolean res = isNStraightHand(hand, W);
		System.out.println(res);

	}

	public static boolean isNStraightHand(int[] hand, int W) {

		TreeMap<Integer, Integer> c = new TreeMap<Integer, Integer>();
		for (int i : hand)
			c.put(i, c.getOrDefault(i, 0) + 1);
		for (int it : c.keySet())
			if (c.get(it) > 0)
				for (int i = W - 1; i >= 0; --i) {
					if (c.getOrDefault(it + i, 0) < c.get(it))
						return false;
					c.put(it + i, c.get(it + i) - c.get(it));
				}
		return true;
	}

}
