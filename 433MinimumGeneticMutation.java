package com.leetcode.MinimumGeneticMutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

	public static void main(String[] args) {
		
		String start = "AAAAAAAA";
		String end = "CCCCCCCC";
		String[] bank = {"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"};
		System.out.println(minMutation(start, end, bank));
		
	}

	public static int minMutation(String start, String end, String[] bank) {

		int level = 1;
		char[] base = {'A','C','G','T'};
		List<String> list = new ArrayList<String>();
		for(int i = 0;i<bank.length;i++){
			list.add(bank[i]);
		}
		Set<String> used = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		used.add(start);
		while(!queue.isEmpty()){
			int times = queue.size();
			for(int i = 0;i<times;i++){
				String cur = queue.poll();
				char[] curr = cur.toCharArray();
				for(int j = 0;j<8;j++){
					for(int k = 0;k<base.length;k++){
						if(base[k] != cur.charAt(j)){
							char old = curr[j];
							curr[j] = base[k];
							String next = new String(curr);
							if(list.contains(next) && !used.contains(next)){
								if(next.equals(end)){
									return level;
								}else{
									queue.add(next);
									used.add(next);
								}
							}
							curr[j] = old;
						}
					}
				}
			}
			level ++;
		}
		return -1;
	}
}
