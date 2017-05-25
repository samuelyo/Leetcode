package com.leetcode.StudentAttendanceRecordI;

public class StudentAttendanceRecordI2 {

	public static void main(String[] args) {
		
		String s = "LLPPPLL";
		System.out.println(checkRecord(s));

	}

	public static boolean checkRecord(String s) {
		
		return !s.matches(".*LLL.*|.*A.*A.*");
	}
}
