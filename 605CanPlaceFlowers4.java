package com.leetcode.CanPlaceFlowers;

public class CanPlaceFlowers4 {

	public static void main(String[] args) {
		
		int[] flowerbed = {1,0,0,0,0,1};
		int n = 2;
		System.out.println(canPlaceFlowers(flowerbed, n));

	}
	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		
		int max = 0;
		for(int i = 0;i<flowerbed.length;i++) {
			if(flowerbed[i] == 0) {
				if(i == 0 || flowerbed[i - 1] == 0) {
					if(i + 1 == flowerbed.length || flowerbed[i + 1] == 0) {
						max ++;
						flowerbed[i] = 1;
					}
				}
			}
		}
		return max >= n;
		
	}

}
