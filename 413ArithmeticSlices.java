package com.leetcode.ArithmeticSlices;

import java.util.Arrays;

public class ArithmeticSlices {

	public static void main(String[] args) {
		
		int[] A = {1, 2, 3, 4,4,3,2,1};
		System.out.println(numberOfArithmeticSlices(A));

	}
	
	public static int numberOfArithmeticSlices(int[] A) {
		
		if(A == null || A.length < 3){
			return 0;
		}
		int len = A.length;
		int[] dp = new int[len+1];
		int count = 0;
		for(int i = 1;i<=len-2;i++){
			Arrays.fill(dp, 0);
			int start = i+2;
			if(A[start-1] - A[start-2] == A[start-2] - A[start-3]){
				dp[start] = A[start-1] - A[start-2];
				count ++;
				for(int j = start+1;j<=len;j++){
					if(A[j-1] - A[j-2] == dp[j-1]){
						dp[j] = dp[j-1];
						count ++;
					}else{
						break;
					}
				}
			}else{
				continue;
			}
		}
		
		return count;
	}

}
