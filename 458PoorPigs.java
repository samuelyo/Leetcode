package com.leetcode.PoorPigs;

public class PoorPigs {

	public static void main(String[] args) {
		
		int buckets = 1000;
		int minutesToDie = 15;
		int minutesToTest = 60;

		System.out.println(poorPigs(buckets, minutesToDie, minutesToTest));
	}
	
	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		
		int largestNum = minutesToTest / minutesToDie + 1;
		int res = 0;
		while(Math.pow(largestNum, res) < buckets){
			res ++;
		}
		return res;
		
	}

}
