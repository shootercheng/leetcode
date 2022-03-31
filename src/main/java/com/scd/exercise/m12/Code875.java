package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code875 {

    public int minEatingSpeed(int[] piles, int H) {
        int lenp = piles.length;
        if (lenp == 0 || H < lenp) {
            return -1;
        }
        int avgTime = H / lenp;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
            if (pile < min) {
                min = pile;
            }
        }
        int mod = max % avgTime;
        int maxSpeed = max / avgTime;
        if (mod != 0) {
            maxSpeed = maxSpeed + 1;
        }
        int minSpeed = min / avgTime;
        // 最小速度为 0 的时候 加1
        if (minSpeed == 0) {
            minSpeed = minSpeed + 1;
        }
        int resultSpeed = Integer.MAX_VALUE;
        while (minSpeed <= maxSpeed) {
            int mid = (minSpeed + maxSpeed) / 2;
            int leftTime = isEatAll(piles, mid, H);
            if (leftTime > 0) {
                minSpeed = mid + 1;
            } else {
                maxSpeed = mid - 1;
                if (mid < resultSpeed) {
                    resultSpeed = mid;
                }
            }
        }
        return resultSpeed;
    }

    private int isEatAll(int[] piles, int speed, int h) {
        int sumTime = 0;
        for (int pile : piles) {
            int modTime = pile % speed;
            int curTime = pile / speed;
            if (modTime != 0) {
                sumTime = sumTime + curTime + 1;
            } else {
                sumTime = sumTime + curTime;
            }
        }
        return sumTime - h;
    }

    public static void main(String[] args) {
//        [312884470]
//        312884469
//        [312884470]
//        968709470
        int[] piles = new int[]{30,11,23,4,20};
        Code875 code875 = new Code875();
        code875.minEatingSpeed(piles, 6);
    }
}
