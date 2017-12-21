package com.leetcode.OneBitAndTwoBitCharacters;

public class OneBitAndTwoBitCharacters4 {

	public static void main(String[] args) {
		
		int[] bits = {0};
		System.out.println(isOneBitCharacter(bits));

	}

	public static boolean isOneBitCharacter(int[] bits) {
		
		int index = 0;
		while(index < bits.length - 1) {
			if(bits[index] == 0) {
				index ++;
			}else {
				index += 2;
			}
		}
		return index == bits.length - 1 ? true : false;
		
	}
}
