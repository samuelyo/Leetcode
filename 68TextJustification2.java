package com.leetcode.TextJustification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification2 {

	public static void main(String[] args) {

		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		int maxWidth = 16;
		List<String> res = fullJustify(words, maxWidth);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

	public static List<String> fullJustify(String[] words, int maxWidth) {

		List<String> res = new ArrayList<String>();
		for (int i = 0, k; i < words.length; i = k) {
			// i: the index of word
			// k: the current index of words in the line
			// len: current total len of words in the line
			int len = -1;
			for (k = i; k < words.length && len + words[k].length() + 1 <= maxWidth; k++) {
				len += words[k].length() + 1;
			}
			StringBuilder curStr = new StringBuilder(words[i]);
			int space = 1, extra = 0;
			// not 1 char, not last line
			if (k != i + 1 && k != words.length) {
				space = (maxWidth - len) / (k - i - 1) + 1; // 1 is for another space
				extra = (maxWidth - len) % (k - i - 1);
			}
			// not 1 char, including last line, initialize space == 1 is to deal
			// with last line case.
			for (int j = i + 1; j < k; j++) { // j: index of word in the current
												// line
				for (int s = space; s > 0; s--)
					curStr.append(" "); // add the "even" space
				if (extra-- > 0)
					curStr.append(" ");
				curStr.append(words[j]);
			}
			// if it's the last line
			int strLen = maxWidth - curStr.length();
			while (strLen-- > 0)
				curStr.append(" ");
			res.add(curStr.toString());
		}
		return res;
	}

}
