package com.leetcode.PoorPigs;

public class PoorPigs2 {

	public static void main(String[] args) {
		
		int buckets = 1000;
		int minutesToDie = 15;
		int minutesToTest = 60;

		System.out.println(poorPigs(buckets, minutesToDie, minutesToTest));
	}
	
	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		
		int large = minutesToTest / minutesToDie + 1;
		int res = 0;
		while(Math.pow(large, res) < buckets) {
			res ++;
		}
		return res;
		
	}

}
