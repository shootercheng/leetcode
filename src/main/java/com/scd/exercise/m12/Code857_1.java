package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code857_1 {

    public int minEatingSpeed(int[] piles, int H) {
        int lenp = piles.length;
        if (lenp == 0 || H < lenp) {
            return -1;
        }
        int avgTime = H / lenp;
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        int mod = max % avgTime;
        int maxSpeed = max / avgTime;
        if (mod != 0) {
            maxSpeed = maxSpeed + 1;
        }
        int minSpeed = maxSpeed;
        for (int i = maxSpeed; i >= 1; i--) {
            if (isEatAll(piles, i, H)) {
                minSpeed = i;
            } else {
                break;
            }
        }
        return minSpeed;
    }

    private boolean isEatAll(int[] piles, int speed, int h) {
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
        return sumTime <= h;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{312884470};
        Code857_1 code857_1 = new Code857_1();
        int lo = 1;
        int hi = 1_000_000_000;
        System.out.println(code857_1.minEatingSpeed(piles, 312884469));
        System.out.println(hi);
    }
}
