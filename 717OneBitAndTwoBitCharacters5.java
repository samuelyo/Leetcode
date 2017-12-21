package com.leetcode.OneBitAndTwoBitCharacters;

import java.util.Arrays;

public class OneBitAndTwoBitCharacters5 {

	public static void main(String[] args) {
		
		int[] bits = {1,1,1,0};
		System.out.println(isOneBitCharacter(bits));

	}

	public static boolean isOneBitCharacter(int[] bits) {
		
		if(bits.length == 1) {
			return true;
		}
		if(bits[bits.length - 2] == 0) {
			return true;
		}
		return !isValid(Arrays.copyOfRange(bits, 0, bits.length - 2));
	}
	
	public static boolean isValid(int[] bits) {
		
		boolean[] dp = new boolean[bits.length + 1];
		dp[0] = true;
		for(int i = 1;i<dp.length;i++) {
			if(bits[i - 1] == 0) {
				if(i - 2 >= 0 && bits[i - 2] == 1) {
					dp[i] = dp[i - 1] || dp[i - 2];
				}else {
					dp[i] = dp[i - 1];
				}
			}else {
				if(i - 2 >= 0 && bits[i - 2] == 1) {
					dp[i] = dp[i - 2];
				}else {
					dp[i] = false;
				}
			}
		}
		return dp[dp.length - 1];
	}
}
