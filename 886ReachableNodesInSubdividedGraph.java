package com.leetcode.ReachableNodesInSubdividedGraph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReachableNodesInSubdividedGraph {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 10}, {0, 2, 1}, {1, 2, 2}};
        int M = 6;
        int N = 3;
        System.out.println(reachableNodes(edges, M, N));
    }

    public static int reachableNodes(int[][] edges, int M, int N) {
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        int result = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        boolean[] visited = new boolean[N];
        pq.offer(new int[]{0, M});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int start = cur[0];
            int move = cur[1];
            if (visited[start]) {
                continue;
            }
            visited[start] = true;
            result++;
            for (int i = 0; i < N; i++) {
                if (graph[start][i] > -1) {
                    if (move > graph[start][i] && !visited[i]) {
                        pq.offer(new int[]{i, move - graph[start][i] - 1});
                    }
                    graph[i][start] -= Math.min(move, graph[start][i]);
                    result += Math.min(move, graph[start][i]);
                }
            }
        }
        return result;
    }
}