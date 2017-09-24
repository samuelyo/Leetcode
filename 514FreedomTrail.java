package com.leetcode.FreedomTrail;

import java.util.Arrays;

public class FreedomTrail {

	public static void main(String[] args) {
		
		String ring = "godding";
		String key = "godding";
		System.out.println(findRotateSteps(ring, key));

	}

	public static int findRotateSteps(String ring, String key) {
		
		int m = ring.length();
		int n = key.length();
		
		int[][] dp = new int[m][n];
		
		for(int i = 0;i<m;i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		return findRotateStepsDFS(dp, ring, key, 0, 0) + key.length();
		
	}
	
	public static int findRotateStepsDFS(int[][] dp, String ring, String key, int ringIndex, int keyIndex) {
		
		if(keyIndex >= key.length()) {
			return 0;
		}
		if(dp[ringIndex][keyIndex] != Integer.MAX_VALUE) {
			return dp[ringIndex][keyIndex];
		}
		
		int step = Integer.MAX_VALUE;
		for(int i = ringIndex;i<ringIndex + ring.length();i++) {
			int curI = i % ring.length();
			if(ring.charAt(curI) == key.charAt(keyIndex)) {
				step = Math.min(step, findRotateStepsDFS(dp, ring, key, curI, keyIndex + 1) + Math.min(i - ringIndex, ring.length() + ringIndex - i));
			}
		}
		dp[ringIndex][keyIndex] = step;
		return step;
	}
}
