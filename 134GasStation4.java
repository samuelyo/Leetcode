package com.leetcode.GasStation;

public class GasStation4 {

	public static void main(String[] args) {
		
		int[] gas = {99,98,97,100};
		int[] cost = {100,100,100,97};
		System.out.println(canCompleteCircuit(gas, cost));

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		
		if(gas == null || cost == null || gas.length == 0 || cost.length == 0) {
			return -1;
		}
		int len = gas.length;
		int sumGas = 0;
		int sumCost = 0;
		int index = 0;
		int tank = 0;
		for(int i = 0;i<len;i++) {
			sumGas += gas[i];
			sumCost += cost[i];
			tank += gas[i] - cost[i];
			if(tank < 0) {
				index = i + 1;
				tank = 0;
			}
		}
		return sumGas < sumCost ? -1 : index;
		
	}
}
