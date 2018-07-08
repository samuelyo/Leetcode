package com.leetcode.ShortestPathToGetAllKeys;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetAllKeys {
    static class Node {
        int i;
        int j;
        int key;
        int step;

        Node(int i, int j, int key, int step) {
            this.i = i;
            this.j = j;
            this.key = key;
            this.step = step;
        }
    }

    static int KEY;

    public static void main(String[] args) {
        String[] grid = {"@..aA", "..B#.", "....b"};
        int res = shortestPathAllKeys(grid);
        System.out.println(res);
    }

    public static int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        char[][] chs = new char[m][n];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            for (int j = 0; j < s.length(); j++) {
                chs[i][j] = s.charAt(j);
                if (chs[i][j] - 'a' >= 0 && chs[i][j] - 'a' < 26) {
                    count++;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            KEY = KEY | (1 << i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chs[i][j] == '@') {
                    return shortestPathAllKeysHelp(i, j, m, n, chs);
                }
            }
        }
        return -1;
    }

    public static int shortestPathAllKeysHelp(int i, int j, int m, int n, char[][] chs) {
        boolean[][][] visited = new boolean[m][n][1025];
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(i, j, 0, 0));
        visited[i][j][0] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.key == KEY) {
                return cur.step;
            }
            for (int k = 0; k < dir.length; k++) {
                int newI = cur.i + dir[k][0];
                int newJ = cur.j + dir[k][1];
                int key = cur.key;
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && chs[newI][newJ] != '0') {
                    char ch = chs[newI][newJ];
                    if (ch == '#' || (Character.isUpperCase(ch) && (key & (1 << (ch - 'A'))) == 0)) {
                        continue;
                    }
                    if (Character.isLowerCase(ch)) {
                        key = key | (1 << (ch - 'a'));
                    }
                    if (!visited[newI][newJ][key]) {
                        visited[newI][newJ][key] = true;
                        Node node = new Node(newI, newJ, key, cur.step + 1);
                        queue.add(node);
                    }
                }
            }
        }
        return -1;
    }
}
