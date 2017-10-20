package com.leetcode.ReverseInteger;

public class ReverseInteger {

	public static void main(String[] args) {
		
		int x = -2147483648;
		int res = reverse(x);
		System.out.println(res);

	}

	public static int reverse(int x) {
		
		boolean isNeg = false;
		Long xLong = new Long(x);
		if(xLong < 0) {
			isNeg = true;
			xLong = -xLong;
		}
		String value = String.valueOf(xLong);
		StringBuilder sb = new StringBuilder(value);
		sb = sb.reverse();
		long val = Long.valueOf(sb.toString());
		if(val > Integer.MAX_VALUE) {
			val = 0;
		}
		if(isNeg) {
			return (int) (0 - val);
		}
		return (int) val;
		
	}
}
