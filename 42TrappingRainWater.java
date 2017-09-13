package com.leetcode.TrappingRainWater;

public class TrappingRainWater {

	public static void main(String[] args) {
		
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));

	}

	public static int trap(int[] height) {
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<height.length;i++){
			max = Math.max(max, height[i]);
		}
		int curHeight = 1;
		while(curHeight <= max) {
			int index = 0;
			while(index < height.length){
				if(height[index] != 0){
					int temp = index;
					while(temp+1 < height.length && height[temp + 1] == 0){
						temp ++;
					}
					if(temp != height.length - 1){
						sum += temp - index;
					}
					height[index] = height[index] - 1 >= 0 ? height[index] - 1 : 0;
					index = temp+1;
				}else{
					index ++;
				}
			}
			curHeight ++;
		}
		return sum;
		
	}
}
