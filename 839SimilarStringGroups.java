package com.leetcode.SimilarStringGroups;

public class SimilarStringGroups {

	static class DSU {
		int[] parent;
		int count;
		int[] rank;

		DSU(int size) {
			parent = new int[size];
			rank = new int[size];
			for (int i = 0; i < size; i++) {
				parent[i] = i;
			}
			count = size;
		}

		int find(int x) {
			if (parent[x] != x) {
				parent[x] = find(parent[x]);
			}
			return parent[x];
		}

		void union(int x, int y) {
			int root1 = find(x);
			int root2 = find(y);
			if (root1 != root2) {
				count--;
				if (rank[root1] < rank[root2]) {
					parent[root1] = root2;
				} else if (rank[root1] == rank[root2]) {
					rank[root2]++;
					parent[root1] = root2;
				} else {
					parent[root2] = root1;
				}
			}
		}

	}

	public static void main(String[] args) {

		String[] A = {"tars","rats","arts","star"};
		int res = numSimilarGroups(A);
		System.out.println(res);

	}

	public static int numSimilarGroups(String[] A) {

		int size = A.length;
		DSU dsu = new DSU(size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != j && isSimilar(A[i], A[j])) {
					dsu.union(i, j);
				}
			}
		}
		return dsu.count;

	}

	public static boolean isSimilar(String s1, String s2) {
		int length = s1.length();
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
		}
		return count == 2;
	}

}
