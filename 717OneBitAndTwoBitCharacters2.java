package com.leetcode.OneBitAndTwoBitCharacters;

public class OneBitAndTwoBitCharacters2 {

	public static void main(String[] args) {

		int[] bits = { 1, 0, 1, 1, 0 };
		boolean res = isOneBitCharacter(bits);
		System.out.println(res);

	}

	public static boolean isOneBitCharacter(int[] bits) {

		int n = bits.length, i = 0;
		while (i < n - 1) {
			if (bits[i] == 0)
				i++;
			else
				i += 2;
		}
		return i == n - 1 ? true : false;

	}

}
