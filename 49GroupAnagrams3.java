package com.leetcode.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams3 {

	public static void main(String[] args) {
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> ans = groupAnagrams(strs);
		for(int i = 0;i<ans.size();i++){
			List<String> res = ans.get(i);
			for(int j = 0;j<res.size();j++){
				System.out.print(res.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String str : strs) {
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			String temp = new String(chs);
			if(map.containsKey(temp)) {
				map.get(temp).add(str);
			}else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(temp, list);
			}
		}
		for(String key : map.keySet()) {
			res.add(map.get(key));
		}
		return res;
		
	}

}
