package com.leetcode.SuperWashingMachines;

public class SuperWashingMachines2 {

	public static void main(String[] args) {

		int[] machines = { 0, 0, 11, 5 };
		System.out.println(findMinMoves(machines));

	}

	/**
	 * We can calculate (required dresses) - (contained dresses) of each side as
	 * L and R:
	 * 
	 * L > 0 && R > 0: both sides lacks dresses, and we can only export one
	 * dress from current machines at a time, so result is abs(L) + abs(R) L < 0
	 * && R < 0: both sides contains too many dresses, and we can import dresses
	 * from both sides at the same time, so result is max(abs(L), abs(R)) L < 0
	 * && R > 0 or L >0 && R < 0: the side with a larger absolute value will
	 * import/export its extra dresses from/to current machine or other side, so
	 * result is max(abs(L), abs(R))
	 * 
	 * @param machines
	 * @return
	 */

	public static int findMinMoves(int[] machines) {

		int[] sums = new int[machines.length + 1];
		for (int i = 0; i < machines.length; i++) {
			sums[i + 1] = sums[i] + machines[i];
		}
		if (sums[sums.length - 1] % machines.length != 0) {
			return -1;
		}
		int average = sums[sums.length - 1] / machines.length;
		int res = 0;
		for (int i = 1; i <= machines.length; i++) {
			int left = average * (i - 1) - sums[i - 1];
			int right = average * (machines.length - i) - (sums[machines.length] - sums[i]);
			if (left > 0 && right > 0) {
				res = Math.max(res, left + right);
			} else {
				res = Math.max(res, Math.max(Math.abs(left), Math.abs(right)));
			}
		}
		return res;

	}
}
