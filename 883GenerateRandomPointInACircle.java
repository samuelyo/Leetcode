package com.leetcode.GenerateRandomPointInACircle;

public class GenerateRandomPointInACircle {
    double radius, x, y;

    public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        radius = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * radius;
        double deg = Math.random() * 360;
        return new double[]{x + len * Math.cos(deg), y + len * Math.sin(deg)};
    }
}
