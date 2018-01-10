package com.leetcode.RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses3 {

	public static void main(String[] args) {
		
		String s = "010010";
		List<String> ans = restoreIpAddresses(s);
		System.out.println(ans.size());
		for(int i = 0;i<ans.size();i++){
			System.out.println(ans.get(i));
		}

	}
	
	public static List<String> restoreIpAddresses(String s) {
		
		List<String> res = new ArrayList<String>();
		if(s == null || s.length() < 4 || s.length() > 12){
			return res;
		}
		List<Integer> list = new ArrayList<Integer>();
		restoreIpAddressesHelp(res, list, s, 0);
		return res;
		
	}

	public static void restoreIpAddressesHelp(List<String> res, List<Integer> list, String s, int start) {
		
		if(start > s.length()) {
			return ;
		}
		if(start == s.length()) {
			if(list.size() == 4) {
				int count = 0;
				StringBuilder sb = new StringBuilder();
				for(int i = 0;i<list.size();i++) {
					if(list.get(i) < 256 && list.get(i) >= 0) {
						sb.append(list.get(i) + ".");
						count ++;
					}
				}
				if(count == 4) {
					sb = sb.deleteCharAt(sb.length() - 1);
					res.add(sb.toString());
				}
			}
		}
		for(int i = start;i < start + 3 && i < s.length();i++) {
			String temp = s.substring(start, i + 1);
			if(temp.length() == 1 || (temp.length() > 1 && temp.charAt(0) != '0')) {
				int cur = Integer.valueOf(s.substring(start, i + 1));
				list.add(cur);
				restoreIpAddressesHelp(res, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
}
