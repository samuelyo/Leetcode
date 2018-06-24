package com.leetcode.MirrorReflection;

public class MirrorReflection2 {

	class Point {
		double x;
		double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static int p;

	Point P_LB; // left - bottom
	Point P_LT;
	Point P_RB;
	Point P_RT; // right - top

	public int mirrorReflection(int p, int q) {
		this.p = p;
		P_LB = new Point(0.0, 0.0);
		P_LT = new Point(0.0, (double) p);
		P_RB = new Point((double) p, 0.0);
		P_RT = new Point((double) p, (double) p);

		Point start = new Point(0.0, 0.0);
		Point end = new Point((double) p, (double) q);

		while (!isCorner(end)) {
			Point mirror = findMirPoint(start, end);
			Point next = insect(end, mirror);

			start = end;
			end = next;
		}

		if (isEquals(end, P_LT)) {
			return 2;
		}

		if (isEquals(end, P_RT)) {
			return 1;
		}

		if (isEquals(end, P_RB)) {
			return 0;
		}

		return -1;
	}

	private boolean isCorner(Point end) {
		if (Math.abs(end.x - 0.0) < 0.001) {
			return Math.abs(end.y - p) < 0.001; // corner 2
		} else if (Math.abs(end.x - p) < 0.001) {
			return Math.abs(end.y - 0.0) < 0.001 || Math.abs(end.y - p) < 0.001; // corner
																					// 0
																					// ||
																					// corner
																					// 1
		} else {
			return false;
		}

	}

	private Point findMirPoint(Point start, Point end) {
		// left or right mirror
		if (Math.abs(end.x - 0.0) < 0.001 || Math.abs(end.x - p) < 0.001) { 
			return new Point(start.x, end.y * 2 - start.y);
			/*
			 * if(start.y<end.y){ return new
			 * Point(start.x,end.y+(end.y-start.y)); }else{ return new
			 * Point(start.x,end.y-(start.y-end.y)); }
			 */

		} else { // Math.abs(end.y-0.0)<0.001 || Math.abs(end.y-p)<0.001
					// //bottom or top mirror
			return new Point(end.x * 2 - start.x, start.y);
		}
	}

	private boolean inBound(Point next) {
		return next.x > -0.001 && next.x < p + 0.001 && next.y > -0.001 && next.y < p + 0.001;
	}

	private boolean isEquals(Point a, Point b) {
		return Math.abs(a.x - b.x) < 0.001 && Math.abs(a.y - b.y) < 0.001;
	}

	private Point insect(Point end, Point next) {

		Point temp1 = calculateIntersectionPoint(end, next, P_LB, P_LT);
		Point temp2 = calculateIntersectionPoint(end, next, P_LB, P_RB);
		Point temp3 = calculateIntersectionPoint(end, next, P_RT, P_LT);
		Point temp4 = calculateIntersectionPoint(end, next, P_RT, P_RB);

		Point[] pArr = new Point[] { temp1, temp2, temp3, temp4 };

		for (Point temp : pArr) {
			if (inBound(temp) && !isEquals(temp, end))
				return temp;
		}

		return null;
	}

	private double calculateVectorProduct(Point P1, Point P2, Point P3, Point P4) {
		return (P2.x - P1.x) * (P4.y - P3.y) - (P2.y - P1.y) * (P4.x - P3.x);
	}

	private Point calculateIntersectionPoint(Point A, Point B, Point C, Point D) {
		double t1 = calculateVectorProduct(C, D, A, B);
		double t2 = calculateVectorProduct(A, B, A, C);
		double x = C.x + (D.x - C.x) * t2 / t1;
		double y = C.y + (D.y - C.y) * t2 / t1;
		return new Point(x, y);
	}

}
