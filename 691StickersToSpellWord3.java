package com.leetcode.StickersToSpellWord;

import java.util.HashMap;
import java.util.Map;

public class StickersToSpellWord3 {

	public static void main(String[] args) {

		String[] stickers = { "with", "example", "science" };
		String target = "thehat";
		System.out.println(minStickers(stickers, target));

	}

	public static int minStickers(String[] stickers, String target) {

		Map<String,Integer> dp = new HashMap<String,Integer>();
		int m = stickers.length;
		int[][] sti = new int[m][26];
		for(int i = 0;i<m;i++) {
			String cur = stickers[i];
			for(int j = 0;j<cur.length();j++) {
				sti[i][cur.charAt(j) - 'a'] ++;
			}
		}
		dp.put("", 0);
		return minStickersHelp(stickers, target, dp, sti);
		
	}
	
	public static int minStickersHelp(String[] stickers, String target, Map<String,Integer> dp, int[][] sti) {
		
		if(dp.containsKey(target)) {
			return dp.get(target);
		}
		
		int res = Integer.MAX_VALUE;
		int[] tar = new int[26];
		for(int i = 0;i<target.length();i++) {
			tar[target.charAt(i) - 'a'] ++;
		}
		for(int i = 0;i<stickers.length;i++) {
			if(sti[i][target.charAt(0) - 'a'] == 0) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			for(int j = 0;j<26;j++) {
				if(tar[j] > 0) {
					for(int k = 0;k<Math.max(0, tar[j] - sti[i][j]);k++) {
						sb.append((char)('a' + j));
					}
				}
			}
			if(sb.length() != target.length()) {
				int temp = minStickersHelp(stickers, sb.toString(), dp, sti);
				if(temp != -1) {
					res = Math.min(res, 1 + temp);
				}
			}
		}
		dp.put(target, res == Integer.MAX_VALUE ? -1 : res);
		return dp.get(target);
		
	}
}
