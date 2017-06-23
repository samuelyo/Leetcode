package com.leetcode.MinimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists2 {

	public static void main(String[] args) {

		String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] list2 = { "KFC", "Shogun", "Burger King" };
		String[] ans = findRestaurant(list1, list2);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	public static String[] findRestaurant(String[] list1, String[] list2) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> res = new LinkedList<String>();
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < list1.length; i++)
			map.put(list1[i], i);
		for (int i = 0; i < list2.length; i++) {
			Integer j = map.get(list2[i]);
			if (j != null && i + j <= minSum) {
				if (i + j < minSum) {
					res = new LinkedList<String>();
					minSum = i + j;
				}
				res.add(list2[i]);
			}
		}
		return res.toArray(new String[res.size()]);
	}

}
