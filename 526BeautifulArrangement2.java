package com.leetcode.BeautifulArrangement;

public class BeautifulArrangement2 {

	public static void main(String[] args) {
		
		int N = 3;
		System.out.println(countArrangement(N));

	}
	
	public static int countArrangement(int N) {
		
		int count = 0;
		boolean[] used = new boolean[N];
		count = countArrangementHelp(1, count, N, used);
		return count;
		
	}
	
	public static int countArrangementHelp(int pos, int count, int N, boolean[] used) {
		
		
		if(pos > N){
			count ++;
			return count;
		}
		
		for(int i = 1;i<=N;i++){
			if(!used[i-1]){
				if(i % pos == 0 || pos % i == 0){
					used[i-1] = true;
					count = countArrangementHelp(pos + 1, count, N, used);
					used[i-1] = false;
				}
			}	
		}
		
		return count;
	}

}
