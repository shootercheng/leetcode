package com.scd.exercise.m12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code1496 {

    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<String> points = new HashSet<>();
        points.add("0_0");
        char[] charArr = path.toCharArray();
        for (char c : charArr) {
            switch (c) {
                case 'N':
                    y = y + 1;
                    if (isTraverse(x, y, points)) {
                        return true;
                    }
                    break;
                case 'S':
                    y = y - 1;
                    if (isTraverse(x, y, points)) {
                        return true;
                    }
                    break;
                case 'W':
                    x = x - 1;
                    if (isTraverse(x, y, points)) {
                        return true;
                    }
                    break;
                case 'E':
                    x = x + 1;
                    if (isTraverse(x, y, points)) {
                        return true;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("input data error");
            }
        }
        return false;
    }

    private boolean isTraverse(int x, int y, Set<String> points) {
        String str = x + "_" + y;
        if (!points.contains(str)) {
            points.add(str);
        } else {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Code1496 code1496 = new Code1496();
        System.out.println(code1496.isPathCrossing("NESWW"));
    }
}
