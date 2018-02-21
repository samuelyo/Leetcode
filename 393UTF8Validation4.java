package com.leetcode.UTF8Validation;

public class UTF8Validation4 {

	public static void main(String[] args) {
		
		int[] data = {240, 162, 138, 147};
		System.out.println(validUtf8(data));

	}

	public static boolean validUtf8(int[] data) {
		
		int index = 0;
		while(index < data.length) {
			String cur = validUtf8Help(data[index]);
			String next = index + 1 < data.length ? validUtf8Help(data[index + 1]) : null;
			String nnext = index + 2 < data.length ? validUtf8Help(data[index + 2]) : null;
			String nnnext = index + 3 < data.length ? validUtf8Help(data[index + 3]) : null;
			if(cur.startsWith("0")) {
				index ++;
			}else if(cur.startsWith("110")) {
				if(next != null && next.startsWith("10")) {
					index += 2;
				}else {
					return false;
				}
			}else if(cur.startsWith("1110")) {
				if(next != null && nnext != null && next.startsWith("10") && nnext.startsWith("10")) {
					index += 3;
				}else {
					return false;
				}
			}else if(cur.startsWith("11110")) {
				if(next != null && nnext != null && nnnext != null && next.startsWith("10") && nnext.startsWith("10") && nnnext.startsWith("10")) {
					index += 4;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		return true;
		
	}
	
	public static String validUtf8Help(int i) {
		
		String temp = Integer.toBinaryString(i);
		if(temp.length() >= 8) {
			return temp.substring(temp.length() - 8, temp.length());
		}else {
			int diff = 8 - temp.length();
			for(int j = 0;j<diff;j++) {
				temp = '0' + temp;
			}
			return temp;
		}
		
	}
}
