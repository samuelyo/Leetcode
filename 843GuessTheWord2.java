package com.leetcode.GuessTheWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuessTheWord2 {

	static class Master {
		public int guess(String s) {
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Pair {
		String s;
		Integer i;

		Pair(String s, Integer i) {
			this.s = s;
			this.i = i;
		}
	}

	public static void findSecretWord(String[] wordlist, Master master) {
		for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
			HashMap<String, Integer> count = new HashMap<>();
			for (String w1 : wordlist)
				for (String w2 : wordlist)
					if (match(w1, w2) == 0)
						count.put(w1, count.getOrDefault(w1, 0) + 1);
			Pair minimax = new Pair("", 1000);
			for (String w : wordlist)
				if (count.getOrDefault(w, 0) < minimax.i)
					minimax = new Pair(w, count.getOrDefault(w, 0));
			x = master.guess(minimax.s);
			List<String> wordlist2 = new ArrayList<String>();
			for (String w : wordlist)
				if (match(minimax.s, w) == x)
					wordlist2.add(w);
			wordlist = wordlist2.toArray(new String[0]);
		}
	}

	public static int match(String a, String b) {
		int matches = 0;
		for (int i = 0; i < a.length(); ++i)
			if (a.charAt(i) == b.charAt(i))
				matches++;
		return matches;
	}

}
