package com.leetcode.ReplaceWords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReplaceWords {

	public static void main(String[] args) {
		
		List<String> dict = new ArrayList<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
		String res = replaceWords(dict, sentence);
		System.out.println(res);

	}
	
	public static String replaceWords(List<String> dict, String sentence) {
		
		List<String>[] dic = new List[26];
		for(int i = 0;i<26;i++){
			dic[i] = new ArrayList<String>();
		}
		for(int i = 0;i<dict.size();i++){
			String cur = dict.get(i);
			Character head = cur.charAt(0);
			dic[head - 'a'].add(cur);
			Collections.sort(dic[head - 'a'], new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.length() - o2.length();
				}
			});
		}
		String[] sen = sentence.split(" ");
		StringBuilder res = new StringBuilder();
		for(int i = 0;i<sen.length;i++){
			String cur = sen[i];
			Character head = cur.charAt(0);
			String replace = null;
			List<String> list = dic[head - 'a'];
			for(int j = 0;j<list.size() && list.get(j).length() <= cur.length();j++){
				if(isSuccessor(list.get(j), cur)){
					replace = list.get(j);
					break;
				}
			}
			if(replace == null){
				replace = cur;
			}
			if(i == 0){
				res.append(replace); 
			}else{
				res.append(" " + replace); 
			}
		}
		return res.toString();
		
	}

	public static boolean isSuccessor(String s, String t) {
		
		boolean res = true;
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) != t.charAt(i)){
				res = false;
				break;
			}
		}
		return res;
	}
}
