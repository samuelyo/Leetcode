package com.leetcode.RemoveComments;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments2 {

	public static void main(String[] args) {

		// String[] source = {"/*Test program */", "int main()", "{ ", "
		// //variable declaration ", "int a, b, c;", "/* This is a test",
		// "multiline ", " comment for ", " testing */", "a = b + c;", "}"};
		// String[] source = {"a/*comment", "line", "more_comment*/b"};
		// String[] source = {"struct Node{", " /*/ declare members;/**/", " int
		// size;", " /**/int val;", "};"};
		// String[] source = { "a//*b//*c", "blank", "d/*/e*//f" };
		// String[] source = {"void func(int k) {", "// this function does
		// nothing /*", " k = k*2/4;", " k = k/2;*/", "}"};
		// String[] source = {"a/*/b//*c","blank","d/*/e*//f"};
		String[] source = { "a/*/b//*c", "blank", "d*//e*//f" };
//		String[] source = {"a//*b/*/c","blank","d/*/e/*/f"};
		List<String> res = removeComments(source);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

	public static List<String> removeComments(String[] source) {

		List<String> res = new ArrayList<String>();
		for (int i = 0; i < source.length; i++) {
			String s = source[i];
			List<Integer> indexes = new ArrayList<Integer>();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '/') {
					indexes.add(j);
				}
			}
			if (indexes.size() == 0) {
				if (!s.equals("")) {
					res.add(s);
				}
			} else {
				boolean changed = false;
				for (int k = 0; k < indexes.size() && !changed; k++) {
					int firstIndex = indexes.get(k);

					if (firstIndex + 2 < s.length() && s.substring(firstIndex, firstIndex + 2).equals("//")) {
						if (!s.substring(0, firstIndex).equals("")) {
							res.add(s.substring(0, firstIndex));
						}
						changed = true;
						continue;
					}

					if (firstIndex + 2 < s.length() && s.substring(firstIndex, firstIndex + 2).equals("/*")) {
						String temp = "";
						temp += s.substring(0, firstIndex);

						int start = i;
						int end = i;
						for (int j = start; j < source.length; j++) {
							String cur = "";
							if (j == start && firstIndex + 2 < source[j].length()) {
								cur = source[j].substring(firstIndex + 2);
							} else {
								cur = source[j];
							}
							if (cur.contains("*/")) {
								
								int ind = cur.indexOf("*/");
								temp += cur.substring(ind + 2);
								source[j] = temp;
								end = j;
								break;
							}
						}
						i = end - 1;
						changed = true;
						continue;
					}
					if (!s.equals("") && changed) {
						res.add(s);
					}

				}
				if (!changed) {
					if (!s.equals("")) {
						res.add(s);
					}
				}
			}

		}
		return res;

	}

}
