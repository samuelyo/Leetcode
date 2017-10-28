package com.leetcode.TopKFrequentWords;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public static void main(String[] args) {
		
		String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k = 4;
		List<String> res = topKFrequent(words, k);
		for(int i = 0;i<res.size();i++) {
			System.out.print(res.get(i) + " ");
		}

	}
	
	static class Word {
		
		String word;
		int times;
		
		Word(String w, int t) {
			word = w;
			times = t;
		}
				
	}

	public static List<String> topKFrequent(String[] words, int k) {

		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String w : words) {
			if(map.containsKey(w)) {
				int temp = map.get(w);
				map.put(w, temp + 1);
			}else {
				map.put(w, 1);
			}
		}
		PriorityQueue<Word> queue = new PriorityQueue<Word>(new Comparator<Word>(){

			@Override
			public int compare(Word o1, Word o2) {
				if(o1.times != o2.times) {
					return o2.times - o1.times;
				}else {
					String s1 = o1.word;
					String s2 = o2.word;
					int s1Index = 0;
					int s2Index = 0;
					while(s1Index < s1.length() && s2Index < s2.length() && s1.charAt(s1Index) == s2.charAt(s2Index)) {
						s1Index ++;
						s2Index ++;
					}
					if(s1Index == s1.length()) {
						return -1;
					}
					if(s2Index == s2.length()) {
						return 1;
					}
					return s1.charAt(s1Index) - s2.charAt(s2Index);
				}
			}
			
		});
		
		for(String key : map.keySet()) {
			queue.add(new Word(key, map.get(key)));
		}
		
		List<String> res = new ArrayList<String>();
		for(int i = 0;i<k;i++) {
			res.add(queue.poll().word);
		}
		return res;
		
	}

}
