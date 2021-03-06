package com.leetcode.CanIWin;

import java.util.Arrays;
import java.util.HashMap;

public class CanIWin3 {

	public static void main(String[] args) {

		int maxChoosableInteger = 10;
		int desiredTotal = 1;
		System.out.println(canIWin(maxChoosableInteger, desiredTotal));

	}

	public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (desiredTotal <= 0){
			return true;
		}
		if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal){
			return false;
		}
		return canIWin(desiredTotal, new int[maxChoosableInteger], new HashMap<String, Boolean>());
	}

	private static boolean canIWin(int total, int[] state, HashMap<String, Boolean> hashMap) {
		if(total <= 0){
			return false;
		}
		String curr = Arrays.toString(state);
		if (hashMap.containsKey(curr)){
			return hashMap.get(curr);
		}
		for (int i = 0; i < state.length; i++) {
			if (state[i] == 0) {
				state[i] = 1;
				if (!canIWin(total - (i + 1), state, hashMap)) {
					hashMap.put(curr, true);
					state[i] = 0;
					return true;
				}
				state[i] = 0;
			}
		}
		hashMap.put(curr, false);
		return false;
	}
}
