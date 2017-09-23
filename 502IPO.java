package com.leetcode.IPO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPO {
	
	static class Project implements Comparable<Project>{
		 
		 int profit;
		 int capital;
		 Project(int p, int c) {
			
			 profit = p;
			 capital = c;
			 
		 }
		@Override
		public int compareTo(Project o) {
			
			if(this.capital == o.capital) {
				return o.profit - this.profit;
			}else{
				return this.capital - o.capital;
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		int k = 10;
		int W = 0;
		int[] Profits = {1,2,3};
		int[] Capital = {0,1,2};
		System.out.println(findMaximizedCapital(k, W, Profits, Capital));

	}
	
	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		
		List<Project> list = new ArrayList<Project>();
		for(int i = 0;i<Profits.length;i++) {
			list.add(new Project(Profits[i], Capital[i]));
		}
		Collections.sort(list);
		int count = 0;
		while(count < k) {
			if(list.size() == 0) {
				break;
			}
			int val = 0;
			int index = 0;
			for(int i = 0;i<list.size();i++) {
				if(list.get(i).capital <= W){
					if(list.get(i).profit > val) {
						index = i;
						val = list.get(i).profit;
					}
				}else{
					break;
				}
			}
			list.remove(index);
			W += val;
			count ++;
		}
		return W;
		
	}

}
