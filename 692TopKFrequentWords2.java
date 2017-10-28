package com.leetcode.TopKFrequentWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class TopKFrequentWords2 {

	public static void main(String[] args) {

		String[] words = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		int k = 4;
		List<String> res = topKFrequent(words, k);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<String> topKFrequent(String[] words, int k) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<>((e1, e2) -> {
			if (e1.getValue() != e2.getValue()) {
				return e2.getValue() - e1.getValue();
			} else {
				return e1.getKey().compareToIgnoreCase(e2.getKey());
			}
		});
		sortedset.addAll(map.entrySet());

		List<String> result = new ArrayList<>();
		Iterator<Map.Entry<String, Integer>> iterator = sortedset.iterator();
		while (iterator.hasNext() && k-- > 0) {
			result.add(iterator.next().getKey());
		}
		return result;

	}

}
