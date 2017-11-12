package com.leetcode.OneBitAndTwoBitCharacters;

public class OneBitAndTwoBitCharacters3 {

	public static void main(String[] args) {

		int[] bits = { 1, 0, 1, 1, 0 };
		boolean res = isOneBitCharacter(bits);
		System.out.println(res);

	}

	/**
	 * if there is only one symbol in array the answer is always true (as last element is 0)
		if there are two 0s at the end again the answer is true no matter what the rest symbols are( ...1100, ...1000,)
        if there is 1 right before the last element(...10), the outcome depends on the count of sequential 1, i.e.
        a) if there is odd amount of 1(10, ...01110, etc) the answer is false as there is a single 1 without pair
        b) if it's even (110, ...011110, etc) the answer is true, as 0 at the end doesn't have anything to pair with
	 * @param bits
	 * @return
	 */
	public static boolean isOneBitCharacter(int[] bits) {

		int ones = 0;
		for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
			ones++;
		}
		if (ones % 2 > 0)
			return false;
		return true;

	}

}
