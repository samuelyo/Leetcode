package com.leetcode.GasStation;

public class GasStation2 {

	public static void main(String[] args) {

		int[] gas = { 1, 2, 3, 3 };
		int[] cost = { 2, 1, 5, 1 };
		System.out.println(canCompleteCircuit(gas, cost));

	}

	/**
	 * If car starts at A and can not reach B. Any station between A and B can
	 * not reach B.(B is the first station that A can not reach.) 
	 * If the total number of gas is bigger than the total number of cost. 
	 * There must be a solution.
	 * 
	 * @param gas
	 * @param cost
	 * @return
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {

		//1, if sum of gas is more than sum of cost, then there must be a solution. And the question guaranteed that the solution is unique(The first one I found is the right one).
		//2, The tank should never be negative, so restart whenever there is a negative number.
		int sumGas = 0;
		int sumCost = 0;
		int start = 0;
		int tank = 0;
		for (int i = 0; i < gas.length; i++) {
			sumGas += gas[i];
			sumCost += cost[i];
			tank += gas[i] - cost[i];
			if (tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}
		if (sumGas < sumCost) {
			return -1;
		} else {
			return start;
		}

	}
}
