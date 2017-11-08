package com.leetcode.ReverseBits;

public class ReverseBits3 {

	public static void main(String[] args) {
		
//		int n = 1;
		int n = Integer.MAX_VALUE;
		
		System.out.println(reverseBits(n));

	}
	
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	
    	String s = Integer.toBinaryString(n);
    	StringBuilder sReverse = new StringBuilder(s).reverse();
    	if(sReverse.length() < 32) {
    		int diff = 32 - sReverse.length();
    		for(int i = 0;i<diff;i++) {
    			sReverse.append("0");
    		}
    	}
    	long res = 0;
    	for(int i = 0;i<32;i++) {
    		res += (sReverse.charAt(i) - '0') * Math.pow(2, 31 - i);
    	}
    	return (int)res;
    	
    }

}
