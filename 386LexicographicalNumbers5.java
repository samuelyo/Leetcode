package com.leetcode.LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers5 {

	public static void main(String[] args) {

		int n = 299;
		List<Integer> res = lexicalOrder(n);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> lexicalOrder(int n) {

		List<Integer> list = new ArrayList<>(n);
		int curr = 1;
		for (int i = 1; i <= n; i++) {
			list.add(curr);
			if (curr * 10 <= n) {
				curr *= 10;
			} else if (curr % 10 != 9 && curr + 1 <= n) {
				curr++;
			} else {
				while(curr % 10 == 9){
					curr = curr / 10;
				}
				curr ++;
			}
		}
		return list;

	}
}
