package com.leetcode.FindDuplicateFileinSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {

	public static void main(String[] args) {
		
		String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		List<List<String>> ans = findDuplicate(paths);
		for(int i = 0;i<ans.size();i++){
			List<String> res = ans.get(i);
			for(int j = 0;j<res.size();j++){
				System.out.print(res.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<String>> findDuplicate(String[] paths) {
		
		List<List<String>> ans = new ArrayList<List<String>>();
		if(paths == null){
			return ans;
		}
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for(int i = 0;i<paths.length;i++){
			String path = paths[i];
			String[] str = path.split(" ");
			for(int j = 1;j<str.length;j++){
				String temp = str[j];
				int low = 0;
				for(int k = 0;k<temp.length();k++){
					if(temp.charAt(k) == '('){
						low = k;
						break;
					}
				}
				String content = temp.substring(low + 1, temp.length()-1);
				if(!map.containsKey(content)){
					List<String> list = new ArrayList<String>();
					list.add(str[0] + "/" + temp.substring(0,low));
					map.put(content, list);
				}else{
					List<String> list = map.get(content);
					list.add(str[0] + "/" + temp.substring(0,low));
					map.put(content, list);
				}
			}
		}
		
		for(String key : map.keySet()){
			if(map.get(key).size() > 1){
				ans.add(map.get(key));
			}
			
		}
		
		return ans;
	}
}
