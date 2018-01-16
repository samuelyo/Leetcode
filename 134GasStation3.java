package com.leetcode.GasStation;

public class GasStation3 {

	public static void main(String[] args) {
		
		int[] gas = {99,98,97,100};
		int[] cost = {100,100,100,97};
		System.out.println(canCompleteCircuit(gas, cost));

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		
		Integer index = null;
		if(gas == null || cost == null || gas.length == 0 || cost.length == 0) {
			return -1;
		}
		int len = gas.length;
		for(int i = 0;i<len;i++) {
			int sum = 0;
			boolean isValid = true;
			for(int j = i;j<i + len;j++) {
				sum += gas[j % len];
				sum -= cost[j % len];
				if(sum < 0) {
					isValid = false;
					break;
				}
			}
			if(isValid) {
				index = i;
				break;
			}
		}
		return index == null ? -1 : index;
		
	}
}
