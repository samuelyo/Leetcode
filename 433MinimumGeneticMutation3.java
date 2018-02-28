package com.leetcode.MinimumGeneticMutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation3 {

	public static void main(String[] args) {
		
		String start = "AACCGGTT";
		String end = "AACCGCTA";
		String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
		System.out.println(minMutation(start, end, bank));

	}
	
	public static int minMutation(String start, String end, String[] bank) {
		
		if(bank == null || bank.length == 0) {
			return -1;
		}
		char[] base = {'A', 'C', 'G', 'T'};
		Set<String> bankSet = new HashSet<String>();
		for(String b : bank) {
			bankSet.add(b);
		}
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		int level = 0;
		Set<String> visited = new HashSet<String>();
		visited.add(start);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int k = 0;k < size;k++) {
				String cur = queue.poll();
				if(cur.equals(end)) {
					return level;
				}
				char[] chs = cur.toCharArray();
				for(int i = 0;i<chs.length;i++) {
					char c = chs[i];
					for(int j = 0;j<base.length;j++) {
						if(base[j] != c) {
							chs[i] = base[j];
							if(bankSet.contains(new String(chs)) && !visited.contains(new String(chs))) {
								visited.add(new String(chs));
								queue.add(new String(chs));
							}
						}
					}
					chs[i] = c;
				}
			}
			level ++;
		}
		return -1;
		
	}

}
