package com.leetcode.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow3 {

	public static void main(String[] args) {
		
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] res =findWords(words);
		System.out.println(Arrays.toString(res));

	}
	
	public static String[] findWords(String[] words) {
		
		List<String> res = new ArrayList<String>();
		int[] map = new int[26];
		char[] row1 = new char[]{'q','w','e','r','t','y','u','i','o','p'};
		char[] row2 = new char[]{'a','s','d','f','g','h','j','k','l'};
		char[] row3 = new char[]{'z','x','c','v','b','n','m'};
		List<char[]> list = new ArrayList<char[]>();
		list.add(row1);
		list.add(row2);
		list.add(row3);
		for(int i = 0;i<list.size();i++) {
			char[] cur = list.get(i);
			for(int j = 0;j<cur.length;j++) {
				map[cur[j] - 'a'] = i;
			}
		}
		for(String s : words) {
			String temp = s.toLowerCase();
			int row = map[temp.charAt(0) - 'a'];
			boolean flag = true;
			for(int i = 1;i<s.length();i++) {
				if(map[temp.charAt(i) - 'a'] != row) {
					flag = false;
					break;
				}
			}
			if(flag) {
				res.add(s);
			}
		}
		String[] ret = new String[res.size()];
		for(int i = 0;i<ret.length;i++) {
			ret[i] = res.get(i);
		}
		return ret;
		
	}

}
