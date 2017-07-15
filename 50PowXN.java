package com.leetcode.PowXN;

public class PowXN {

	public static void main(String[] args) {
		
		double x = 2.00000;
//		int n = -2147483648;
		int n = 3;
		System.out.println(myPow(x, n));

	}

	public static double myPow(double x, int n) {
		
		if(x == 1 || x == 0){
			return x;
		}
		if(n == 0){
			return 1;
		}
		double del = 1;
		int sign = n > 0 ? 1:-1;
		long nLong = (long)n;
		long times = Math.abs(nLong);
		while(times > 0){
			long cur = 1;
			double ans = x;
			while((cur << 1) < times){
				ans *= ans;
				cur <<= 1;
			}
			times -= cur;
			del *= ans;
		}
		if(sign == 1){
			return del;
		}else{
			return 1/del;
		}
		
	}
}
