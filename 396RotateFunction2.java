package com.leetcode.RotateFunction;

public class RotateFunction2 {

	public static void main(String[] args) {
		
		int[] A = {4,3,2,6};
		System.out.println(maxRotateFunction(A));

	}
	
	public static int maxRotateFunction(int[] A) {
		
		int res = 0;
		int len = A.length;
		int ASum = 0;
		for(int i = 0;i<len;i++){
			ASum += A[i];
			res += i * A[i];
		}
		int sum = res;
		for(int i = len-1;i>=0;i--){
			sum -= (len-1) *A[i];
			sum += (ASum - A[i]);
			//sum = sum + ASum - len*A[i];
			res = Math.max(res, sum);
		}
		return res;
		
	}
}
