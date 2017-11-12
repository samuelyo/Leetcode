package com.leetcode.OneBitAndTwoBitCharacters;

import java.util.Arrays;

public class OneBitAndTwoBitCharacters {

	public static void main(String[] args) {
		
		int[] bits = {1,0,1,1,0};
		boolean res = isOneBitCharacter(bits);
		System.out.println(res);
		
	}
	
	public static boolean isOneBitCharacter(int[] bits) {
		
		if(bits.length == 1) {
			return true;
		}
		int pre = bits[bits.length - 2];
		if(pre == 0) {
			return true;
		}
		return !isValid(Arrays.copyOfRange(bits, 0, bits.length - 2));
		
		
	}
	
	public static boolean isValid(int[] bits) {
		
		int len = bits.length;
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;
		for(int i = 1;i<=len;i++) {
			if(bits[i - 1] == 0) {
				dp[i] = dp[i - 1] || dp[i - 2];
			}else {
				if(i - 2 >= 0 && bits[i - 2] == 1) {
					dp[i] = dp[i - 2];
				}else {
					dp[i] = false;
				}
			}
		}
		return dp[len];
		
	}

}
