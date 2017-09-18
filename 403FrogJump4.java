package com.leetcode.FrogJump;

import java.util.HashSet;

public class FrogJump4 {

	public static void main(String[] args) {

		int[] stones = { 0, 1, 2,3,4,5,6,7 };
		boolean res = canCross(stones);
		System.out.println(res);

	}

	public static boolean canCross(int[] stones) {

		if (stones == null || stones.length == 0) {
			return false;
		}
		int n = stones.length;
		if (n == 1) {
			return true;
		}
		if (stones[1] != 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		int last = stones[n - 1];
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (i > 3 && stones[i] > stones[i - 1] * 2) {
				return false;
			} // The two stones are too far away.
			hs.add(stones[i]);
		}
		return canReach(hs, last, 1, 1);

	}

	private static boolean canReach(HashSet<Integer> hs, int last, int pos, int jump) {

		if (pos + jump - 1 == last || pos + jump == last || pos + jump + 1 == last) {
			return true;
		}
		if (hs.contains(pos + jump + 1)) {
			if (canReach(hs, last, pos + jump + 1, jump + 1)) {
				return true;
			}
		}
		if (hs.contains(pos + jump)) {
			if (canReach(hs, last, pos + jump, jump)) {
				return true;
			}
		}
		if (jump > 1 && hs.contains(pos + jump - 1)) {
			if (canReach(hs, last, pos + jump - 1, jump - 1)) {
				return true;
			}
		}
		return false;
		
	}

}
