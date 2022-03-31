package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code278 {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean current = isBadVersion(mid);
            boolean before = isBadVersion(mid - 1);
            if (current && !before) {
                return mid;
            } else if (current) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int i) {
        return false;
    }
}
