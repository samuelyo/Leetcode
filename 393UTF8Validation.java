package com.leetcode.UTF8Validation;

public class UTF8Validation {

	public static void main(String[] args) {
		
		int[] data = {255};
		System.out.println(validUtf8(data));

	}
	
	public static boolean validUtf8(int[] data) {
		
		int index = 0;
		while(index < data.length){
			String curr = validUtf8Help(data[index]);
			if(curr.charAt(0) == '0'){
				index ++;
			}else if(curr.substring(0, 3).equals("110")){
				index ++;
				if(index < data.length && validUtf8Help(data[index]).substring(0,2).equals("10")){
					index ++;
				}else{
					return false;
				}
			}else if(curr.substring(0, 4).equals("1110")){
				index ++;
				if(index < data.length && validUtf8Help(data[index]).substring(0,2).equals("10")){
					index ++;
					if(index < data.length && validUtf8Help(data[index]).substring(0,2).equals("10")){
						index ++;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else if(curr.substring(0, 5).equals("11110")){
				index ++;
				if(index < data.length && validUtf8Help(data[index]).substring(0,2).equals("10")){
					index ++;
					if(index < data.length && validUtf8Help(data[index]).substring(0,2).equals("10")){
						index ++;
						if(index < data.length && validUtf8Help(data[index]).substring(0,2).equals("10")){
							index ++;
						}else{
							return false;
						}
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static String validUtf8Help(int num) {
		
		String s = Integer.toBinaryString(num & 511);
		if(s.length() == 8){
			return s;
		}else{
			StringBuilder sb = new StringBuilder(s);
			sb = sb.reverse();
			int diff = 8 - s.length();
			for(int i = 0;i<diff;i++){
				sb.append("0");
			}
			sb = sb.reverse();
			return sb.toString();
		}
	}

}
