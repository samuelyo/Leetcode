package com.leetcode.BeautifulArrangement;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {

	public static void main(String[] args) {
		
		int N = 4;
		System.out.println(countArrangement(N));

	}
	
	public static int countArrangement(int N) {
		
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		boolean[] used = new boolean[N];
		count = countArrangementHelp(list, count, N, used);
		return count;
		
	}
	
	public static int countArrangementHelp(List<Integer> list, int count, int N, boolean[] used) {
		
		
		if(list.size() == N){
			count ++;
			return count;
		}
		
		for(int i = 1;i<=N;i++){
			if(!used[i-1]){
				int len = list.size();
				if(i % (len + 1) == 0 || (len + 1) % i == 0){
					list.add(i);
					used[i-1] = true;
					count = countArrangementHelp(list, count, N, used);
					list.remove(list.size() - 1);
					used[i-1] = false;
				}
			}	
		}
		
		return count;
	}

}
