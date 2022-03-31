package com.scd.exercise.y2022.m3;

/**
 * @author James
 */
public class Code2011 {

    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            if ("X++".equals(operation) || "++X".equals(operation)) {
                result++;
            } else if ("X--".equals(operation) || "--X".equals(operation)) {
                result--;
            }
        }
        return result;
    }
}
