package com.leetcode.AssignCookies;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {
		
		int[] g = {1,2,3,2,3};
		int[] s = {1,4,2,3};
		System.out.println(findContentChildren(g, s));

	}
	
	public static int findContentChildren(int[] g, int[] s) {
		
		Arrays.sort(g);
		Arrays.sort(s);
		int ans = 0;
		int index_s = 0;
		int index_g = 0;
		while(index_s < s.length && index_g < g.length){
			if(g[index_g] <= s[index_s]){
				ans ++;
				index_s ++;
				index_g ++;
			}else{
				index_s ++;
			}
		}
		return ans;
		
	}

}
