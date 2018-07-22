package com.leetcode.WalkingRobotSimulation;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WalkingRobotSimulation {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        int res = robotSim(commands, obstacles);
        System.out.println(res);
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        int x = 0;
        int y = 0;
        int dir = 1;
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            int[] cur = obstacles[i];
            Point point = new Point(cur[0], cur[1]);
            set.add(point);
        }
        for (int i = 0; i < commands.length; i++) {
            int cur = commands[i];
            if (cur > 0) {
                for (int j = 0; j < cur; j++) {
                    if (dir == 1) {
                        if (isBlock(set, x, y + 1)) {
                            break;
                        }
                        y++;
                    }
                    if (dir == -1) {
                        if (isBlock(set, x, y - 1)) {
                            break;
                        }
                        y--;
                    }
                    if (dir == 2) {
                        if (isBlock(set, x + 1, y)) {
                            break;
                        }
                        x++;
                    }
                    if (dir == -2) {
                        if (isBlock(set, x - 1, y)) {
                            break;
                        }
                        x--;
                    }
                    res = Math.max(res, x * x + y * y);
                }
            } else {
                dir = nextDir(dir, cur);
            }
        }
        return res;
    }

    private static boolean isBlock(Set<Point> set, int i, int y) {
        return set.contains(new Point(i, y));
    }

    private static int nextDir(int dir, int cur) {
        if (cur == -1) {
            if (dir == 1) {
                dir = 2;
            } else if (dir == -1) {
                dir = -2;
            } else if (dir == 2) {
                dir = -1;
            } else {
                dir = 1;
            }
        } else {
            if (dir == 1) {
                dir = -2;
            } else if (dir == -1) {
                dir = 2;
            } else if (dir == 2) {
                dir = 1;
            } else {
                dir = -1;
            }
        }
        return dir;
    }
}
