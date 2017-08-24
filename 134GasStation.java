package com.leetcode.GasStation;

public class GasStation {

	public static void main(String[] args) {
		
		int[] gas = {99,98,97,100};
		int[] cost = {100,100,100,97};
		System.out.println(canCompleteCircuit(gas, cost));

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		
		int index = -1;
		for(int i = 0;i<gas.length;i++){
			int sum = 0;
			for(int j = i;j< i + gas.length;j++){
				sum += gas[j % gas.length];
				sum -= cost[j % gas.length];
				if(sum < 0){
					break;
				}
			}
			if(sum >= 0){
				index = i;
				break;
			}
		}
		return index;
		
	}
}
