package com.leetcode.DecodeString;

public class DecodeString {

	public static void main(String[] args) {
		
		String s = "2[abc]3[cd]ef";
		String res = decodeString(s);
		System.out.println(res);

	}

	public static String decodeString(String s) {
		
		if(s == "" || s.length() == 0){
			return "";
		}
		StringBuilder res = new StringBuilder();
		int index = 0;
		while(index < s.length()){
			while(index < s.length() && !(s.charAt(index) - '0' >= 0 && s.charAt(index) - '0' <= 9)){
				res.append(s.charAt(index));
				index ++;
			}
			StringBuilder timesStr = new StringBuilder();
			while(index < s.length() && s.charAt(index) - '0' >= 0 && s.charAt(index) - '0' <= 9){
				timesStr.append(s.charAt(index));
				index ++;
			}
			int times ;
			if(timesStr.length() == 0){
				times = 0;
			}else{
				times = Integer.valueOf(timesStr.toString());
			}
			int left = 0;
			int right = 0;
			int start = index;
			while(index < s.length()){
				if(s.charAt(index) == '['){
					left ++;
				}
				if(s.charAt(index) == ']'){
					right ++;
					if(left == right){
						break;
					}
				}
				index ++;
			}
			String next ;
			if(start + 1 < index){
				next = s.substring(start + 1, index);
			}else{
				next = "";
			}
			for(int i = 0;i<times;i++){
				res.append(decodeString(next));
			}
			index ++;
		}
		return res.toString();
		
	}
}
