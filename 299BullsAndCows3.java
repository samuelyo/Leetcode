package com.leetcode.BullsAndCows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows3 {

	public static void main(String[] args) {

		String secret = "1122";
		String guess = "1222";
		String res = getHint(secret, guess);
		System.out.println(res);

	}

	public static String getHint(String secret, String guess) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Set<Integer> bullsIndex = new HashSet<Integer>();
		int bulls = 0;
		int cows = 0;
		for (int i = 0; i < secret.length(); i++) {
			char sCur = secret.charAt(i);
			char gCur = guess.charAt(i);
			if (sCur == gCur) {
				bulls++;
				bullsIndex.add(i);
			}
		}
		for (int i = 0; i < secret.length(); i++) {
			char sCur = secret.charAt(i);
			if (!bullsIndex.contains(i)) {
				if (map.containsKey(sCur)) {
					map.put(sCur, map.get(sCur) + 1);
				} else {
					map.put(sCur, 1);
				}
			}
		}
		for (int i = 0; i < guess.length(); i++) {
			if(!bullsIndex.contains(i)) {
				char gCur = guess.charAt(i);
				if (map.containsKey(gCur) && map.get(gCur) > 0) {
					cows++;
					map.put(gCur, map.get(gCur) - 1);
				}
			}
		}
		return bulls + "A" + cows + "B";

	}

}
