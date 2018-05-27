package com.leetcode.SplitArrayIntoFibonacciSequence;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

	public static void main(String[] args) {

		String S = "1101111";
		List<Integer> res = splitIntoFibonacci(S);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> splitIntoFibonacci(String S) {

		List<Integer> list = new ArrayList<Integer>();
		if (S == null || S.length() < 3) {
			return list;
		}
		splitIntoFibonacciHelp(S, list, 0);
		return list;

	}

	public static boolean splitIntoFibonacciHelp(String S, List<Integer> list, int index) {

		if (index == S.length() && list.size() >= 3) {
			return true;
		}
		for (int i = index; i < S.length(); i++) {
			String next = S.substring(index, i + 1);
			long num = Long.valueOf(next);
			String temp = "" + num;
			if (!next.equals(temp)) {
				break;
			}
			if (num > Integer.MAX_VALUE) {
				break;
			}
			if ((list.size() >= 2 && num == list.get(list.size() - 1) + list.get(list.size() - 2))
					|| list.size() <= 1) {
				list.add((int) num);
				if (splitIntoFibonacciHelp(S, list, index + temp.length())) {
					return true;
				}
				list.remove(list.size() - 1);
			}
		}
		return false;

	}

}
