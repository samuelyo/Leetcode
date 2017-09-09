package com.leetcode.CoinChangeII;

public class CoinChangeII {

	public static void main(String[] args) {
		
		int amount = 500;
		int[] coins = {11,10,9,8,7,5,3};
		System.out.println(change(amount, coins));

	}
	
	public static int change(int amount, int[] coins) {
		
		if(coins == null || coins.length == 0){
			return amount == 0 ? 1 : 0;
		}
		
		int[] max = new int[coins.length];
		for(int i = 0;i<coins.length;i++){
			max[i] = amount / coins[i];
		}
		return changeHelp(amount, coins, 0, max);
		
	}
	
	public static int changeHelp(int amount, int[] coins, int index, int[] max) {
		
		if(amount == 0){
			return 1;
		}
		
		if(index == coins.length - 1){
			if(amount % coins[index] == 0 && amount / coins[index] > 0){
				return 1;
			}else{
				return 0;
			}
		}
		
		int count = 0;
		for(int i = 0;i<=max[index];i++){
			count += changeHelp(amount - i * coins[index], coins, index + 1, max);
		}
		return count;
	}
}
