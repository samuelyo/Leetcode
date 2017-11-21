package com.leetcode.RemoveComments;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

	public static void main(String[] args) {

		// String[] source = {"/*Test program */", "int main()", "{ ", "
		// //variable declaration ", "int a, b, c;", "/* This is a test",
		// "multiline ", " comment for ", " testing */", "a = b + c;", "}"};
		// String[] source = {"a/*comment", "line", "more_comment*/b"};
		// String[] source = {"struct Node{", " /*/ declare members;/**/", " int
		// size;", " /**/int val;", "};"};
//		String[] source = { "a//*b//*c", "blank", "d/*/e*//f" };
		// String[] source = {"void func(int k) {", "// this function does
		// nothing /*", " k = k*2/4;", " k = k/2;*/", "}"};
		// String[] source = {"a/*/b//*c","blank","d/*/e*//f"};
		 String[] source = { "a/*/b//*c", "blank", "d*//e*//f" };
		List<String> res = removeComments(source);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

	public static List<String> removeComments(String[] source) {

		StringBuilder sb = new StringBuilder();
		for (String s : source)
			sb.append(s).append("\n");
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < sb.length();) {
			int j = sb.indexOf("//", i);
			int k = sb.indexOf("/*", i);
			if (j < 0 && k < 0) {
				sb2.append(sb.substring(i));
				break;
			}
			if (j < 0 || (k >= 0 && k < j)) {
				int end = sb.indexOf("*/", k + 2);
				sb2.append(sb.substring(i, k));
				i = end + 2;
			} else {
				int end = sb.indexOf("\n", j + 2);
				sb2.append(sb.substring(i, j));
				i = end;
			}
		}
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < sb2.length();) {
			int j = sb2.indexOf("\n", i);
			if (j < 0)
				break;
			if (j > 0 && sb2.charAt(j - 1) != '\n') {
				ans.add(sb2.substring(i, j));
			}
			i = j + 1;
		}

		return ans;

	}

}
