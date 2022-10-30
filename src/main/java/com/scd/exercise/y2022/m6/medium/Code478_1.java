package com.scd.exercise.y2022.m6.medium;

import java.util.OptionalDouble;
import java.util.Random;

/**
 * @author James
 */
public class Code478_1 {

    static class Solution {
        private double radius;

        private double x;

        private double y;

        private Random random = new Random();

        public Solution(double radius, double x, double y) {
            this.radius = radius;
            this.x = x;
            this.y = y;
        }

        public double[] randPoint() {
//            double moveX = x > 0 ? x : -x;
//            double moveY = y > 0 ? y : -y;
            double xRes = genRandomDouble(-radius, radius);
            double yRes = genyRes(xRes);
            return new double[]{xRes + x, yRes + y};
        }

        private double genyRes(double xRes) {
            double yEdge = Math.sqrt(radius * radius - xRes * xRes) - 0.0000001;
            return genRandomDouble(-yEdge, yEdge);
        }

        public double genRandom() {
            return Math.random() * radius * 2 - radius;
        }

        private double genRandomDouble(double x, double y) {
            return x + Math.random() * y % (y - x + 1);
        }

        private double genRandomDouble2(double x, double y) {
            OptionalDouble optionalDouble = random.doubles(x, y).findAny();
            if (optionalDouble.isPresent()) {
                return optionalDouble.getAsDouble();
            }
            throw new IllegalArgumentException("input param error");
        }
    }
}
