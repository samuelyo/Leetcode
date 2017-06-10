package com.leetcode.TeemoAttacking;

public class TeemoAttacking {

	public static void main(String[] args) {
		
		int[] timeSeries = {5};
		int duration = 2;
		System.out.println(findPoisonedDuration(timeSeries, duration));

	}

	public static int findPoisonedDuration(int[] timeSeries, int duration) {
		
		if(timeSeries == null || timeSeries.length == 0){
			return 0;
		}
		int sum = 0;
		for(int i = 1;i<timeSeries.length;i++){
			if((timeSeries[i] - timeSeries[i-1]) <= duration){
				sum += timeSeries[i] - timeSeries[i-1];
			}else{
				sum += duration;
			}
		}
		return sum + duration;
	}
}
