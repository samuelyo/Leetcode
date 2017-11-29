package com.leetcode.AssignCookies;

import java.util.Arrays;

public class AssignCookies3 {

	public static void main(String[] args) {
		
		int[] g = {1,2,3};
		int[] s = {1,1};
		int res = findContentChildren(g, s);
		System.out.println(res);
		
	}

	public static int findContentChildren(int[] g, int[] s) {

		Arrays.sort(g);
		Arrays.sort(s);
		int res = 0;
		int gIndex = 0;
		int sIndex = 0;
		while(gIndex < g.length && sIndex < s.length) {
			if(s[sIndex] >= g[gIndex]) {
				gIndex ++;
				sIndex ++;
				res ++;
			}else {
				sIndex ++;
			}
		}
		return res;
		
	}
}
