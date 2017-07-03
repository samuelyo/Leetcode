package com.leetcode.WordBreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {

	public static void main(String[] args) {
		
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordBreak(s, wordDict));

	}
	
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		
		Map<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();
		for(int i = 0;i<wordDict.size();i++){
			List<Integer> list ;
			if(map.containsKey(wordDict.get(i).charAt(wordDict.get(i).length() - 1))){
				list = map.get(wordDict.get(i).charAt(wordDict.get(i).length() - 1));
			}else{
				list = new ArrayList<Integer>();
			}
			list.add(i);
			map.put(wordDict.get(i).charAt(wordDict.get(i).length() - 1), list);
		}
		boolean[] flag = new boolean[s.length() + 1];
		flag[0] = true;
		for(int i = 1;i <= s.length();i++){
			char cur = s.charAt(i - 1);
			List<Integer> list = map.get(cur);
			if(list == null){
				flag[i] = false;
			}else{
				for(int j = 0;j < list.size();j++){
					String temp = wordDict.get(list.get(j));
					if(temp.length() <= i){
						String sTemp = s.substring(i - temp.length(), i);
						if(temp.equals(sTemp) && flag[i - temp.length()]){
							flag[i] = true;
						}
					}
				}
			}
		}
		return flag[s.length()];
	}

}
