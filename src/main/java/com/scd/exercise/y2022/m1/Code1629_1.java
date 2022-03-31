package com.scd.exercise.y2022.m1;

/**
 * @author James
 */
public class Code1629_1 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] charArr = keysPressed.toCharArray();
        int maxTime = releaseTimes[0];
        char result = charArr[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int timeKey = releaseTimes[i] - releaseTimes[i - 1];
            if (timeKey > maxTime) {
                maxTime = timeKey;
                result = charArr[i];
            } else if (timeKey == maxTime) {
                if (charArr[i] > result) {
                    result = charArr[i];
                }
            }
        }
        return result;
    }
}
