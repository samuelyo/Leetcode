package com.leetcode.SuperWashingMachines;

public class SuperWashingMachines3 {

	public static void main(String[] args) {

		int[] machines = { 1, 0, 5 };
		System.out.println(findMinMoves(machines));

	}

	public static int findMinMoves(int[] machines) {

		int total = 0;
		for (int i : machines)
			total += i;
		if (total % machines.length != 0)
			return -1;
		int avg = total / machines.length, cnt = 0, max = 0;
		for (int load : machines) {
			cnt += load - avg; // load-avg is "gain/lose"
			max = Math.max(Math.max(max, Math.abs(cnt)), load - avg);
		}
		return max;

	}
}
