package com.leetcode.RussianDollEnvelopes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RussianDollEnvelopes3 {

	public static class Envelope {
		
		int len;
		int wid;
		
		Envelope(int l, int w) {
			len = l;
			wid = w;
		}
	}
	
	public static void main(String[] args) {
		
		int[][] envelopes = {{1,1}};
		System.out.println(maxEnvelopes(envelopes));

	}
	
	public static int maxEnvelopes(int[][] envelopes) {
		
		if(envelopes.length == 0) {
			return 0;
		}
		List<Envelope> list = new ArrayList<Envelope>();
		for(int i = 0;i<envelopes.length;i++){
			list.add(new Envelope(envelopes[i][0], envelopes[i][1]));
		}
		Collections.sort(list, new Comparator<Envelope>() {

			@Override
			public int compare(Envelope o1, Envelope o2) {
				
				if(o1.len != o2.len) {
					return o1.len - o2.len;
				}else{
					return o1.wid - o2.wid;
				}
				
			}
		});
		
		int length = list.size();
		int[] dp = new int[length + 1];
		Arrays.fill(dp, 1);
		int max = 0;
		for(int i = 2;i <= length;i++){
			for(int j = i-1;j>=1;j--){
				if(list.get(j - 1).wid < list.get(i - 1).wid && list.get(j - 1).len < list.get(i - 1).len) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
		
	}

}
