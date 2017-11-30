package com.leetcode.HammingDistance;

public class HammingDistance3 {

	public static void main(String[] args) {
		
		int x = 1;
		int y = 4;
		int res = hammingDistance(x, y);
		System.out.println(res);

	}
	
	public static int hammingDistance(int x, int y) {
		
		int temp = x ^ y;
		return Integer.bitCount(temp);
		
	}

}
