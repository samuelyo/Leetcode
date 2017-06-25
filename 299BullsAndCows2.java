package com.leetcode.BullsAndCows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BullsAndCows2 {

	public static void main(String[] args) {

		String secret = "1123";
		String guess = "0111";
		System.out.println(getHint(secret, guess));

	}

	public static String getHint(String secret, String guess) {

		int bulls = 0;
		int cows = 0;
		int[] numbers = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int s = secret.charAt(i) - '0';
			int g = guess.charAt(i) - '0';
			if (s == g)
				bulls++;
			else {
				if (numbers[s] < 0)
					cows++;
				if (numbers[g] > 0)
					cows++;
				numbers[s]++;
				numbers[g]--;
			}
		}
		return bulls + "A" + cows + "B";

	}
}
