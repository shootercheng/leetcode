package com.scd.exercise.y2022.m6.medium;

import java.util.OptionalDouble;
import java.util.Random;

/**
 * 478. 在圆内随机生成点
 * @author James
 */
public class Code478 {

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
            while (true) {
                double xRes = genRandom();
                double yRes = genRandom();
//                double res = xRes * xRes + yRes * yRes;
//                double circle = radius * radius;
//                if (circle - res >= 0.000001) {
//                    return new double[]{xRes + x, yRes + y};
//                }
                if (Math.sqrt(xRes * xRes + yRes * yRes) <= radius) {
                    return new double[]{xRes + x, yRes + y};
                }
            }
        }

        private double genyRes(double xRes) {
            double yEdge = Math.sqrt(radius * radius - xRes * xRes);
            return genRandomDouble(-yEdge,  yEdge);
        }

         public double genRandom() {
             return Math.random() * radius * 2 - radius;
         }

        private double genRandomDouble(double x, double y) {
            return  x + Math.random() * y % (y - x + 1);
        }

        private double genRandomDouble2(double x, double y) {
            OptionalDouble optionalDouble = random.doubles(x, y).findAny();
            if (optionalDouble.isPresent()) {
                return optionalDouble.getAsDouble();
            }
            throw new IllegalArgumentException("input param error");
        }
    }


    public static void main(String[] args) {
//        Random random = new Random();
//        random.nextDouble();
//        for (int i = 0; i < 100; i++) {
//            OptionalDouble optionalDouble = random.doubles(-1, 1).findAny();
//            if (optionalDouble.isPresent()) {
//                double res = optionalDouble.getAsDouble();
//                System.out.println(res);
//            }
//        }
//        double x = -10;
//        double y = 10;
//        for (int i = 0; i < 100; i++) {
//            double res = x + Math.random() * y % (y - x + 1);
//            System.out.println(res);
//        }

//        Code478 code478 = new Code478();
        Solution solution = new Solution(0.01,-73839.1,-3289891.3);
        for (int i = 0; i < 100; i++) {
            double[] res = solution.randPoint();
            System.out.println(res[0] + "_" + res[1]);
        }
        solution.genyRes(6.9586136312404);

    }
}
