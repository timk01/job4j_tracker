package ru.job4j.oop;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {

    private int x;
    private int y;
    private int z;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public Point(int x, int y, int z) {
       this(x, y);
       this.z = z;
    }

    private double getSquareDistance(Point that) {
        return pow(this.x - that.x, 2) + pow(this.y - that.y, 2);
    }

    public double distance(Point that) {
        return sqrt(getSquareDistance(that));
    }

    public double distance3d(Point that) {
        return Math.sqrt(getSquareDistance(that) + pow(this.z - that.z, 2));
    }

    public void info() {
        System.out.println("Point[" + this.x + ", " + this.y + "]");
    }
}