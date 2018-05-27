package com.leetcode.GuessTheWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessTheWord {

	static class Master {
		public int guess(String s) {
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void findSecretWord(String[] wordlist, Master master) {
		for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
			String guess = wordlist[new Random().nextInt(wordlist.length)];
			x = master.guess(guess);
			List<String> wordlist2 = new ArrayList<>();
			for (String w : wordlist)
				if (match(guess, w) == x)
					wordlist2.add(w);
			wordlist = wordlist2.toArray(new String[wordlist2.size()]);
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
