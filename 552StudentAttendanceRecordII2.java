package com.leetcode.StudentAttendanceRecordII;

public class StudentAttendanceRecordII2 {

	public static void main(String[] args) {
		
		int n = 2;
		System.out.println(checkRecord(n));

	}
	
	public static int M = 1000000007;
	
	public static int checkRecord(int n) {
		
		int[] p = new int[n + 1];
		int[] l = new int[n + 1];
		int[] a = new int[n + 1];
		
		p[0] = 1;
		l[0] = 1;
		a[0] = 1;
		l[1] = 3;
		a[1] = 2;
		a[2] = 4;
		
		for(int i = 1;i<n;i++) {
			p[i] = ( p[i-1] + l[i-1] + a[i-1] ) % M;
			if(i > 1) {
				l[i] = ((a[i-1] + p[i-1]) % M + (a[i-2] + p[i-2]) % M) % M;
			}
			if(i > 2) {
				a[i] = ((a[i-1] + a[i-2]) % M + a[i-3]) % M;
			}
		}
		return p[n-1] + a[n-1] + l[n-1];
		
	}

}
