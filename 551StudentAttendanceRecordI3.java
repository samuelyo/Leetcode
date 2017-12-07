package com.leetcode.StudentAttendanceRecordI;

public class StudentAttendanceRecordI3 {

	public static void main(String[] args) {
		
		String s = "PPALLL";
		System.out.println(checkRecord(s));

	}

	public static boolean checkRecord(String s) {
		
		int numOfA = 0;
		int index = 0;
		while(index < s.length()) {
			char cur = s.charAt(index);
			if(cur == 'A') {
				numOfA ++;
				if(numOfA > 1) {
					return false;
				}
			}
			if(cur == 'L') {
				int temp = index;
				while(temp < s.length() && s.charAt(temp) == 'L') {
					temp ++;
				}
				if(temp - index > 2) {
					return false;
				}
			}
			index ++;
		}
		return true;
		
	}
}
