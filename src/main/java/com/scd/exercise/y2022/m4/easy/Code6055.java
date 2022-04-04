package com.scd.exercise.y2022.m4.easy;

/**
 * 6055. 转化时间需要的最少操作数
 * @author James
 */
public class Code6055 {

    public int convertTime(String current, String correct) {
        int curNum = convertStrToNum(current);
        int corNum = convertStrToNum(correct);
        int[] result = new int[1];
        calMin(corNum - curNum, result);
        return result[0];
    }

    private void calMin(int min, int result[]) {
        if (min >= 60) {
            int left = min % 60;
            result[0] = result[0] + min / 60;
            calMin(left, result);
        } else if (min >= 15) {
            int left = min % 15;
            result[0] = result[0] + min / 15;
            calMin(left, result);
        } else if (min >= 5) {
            int left = min % 5;
            result[0] = result[0] + min / 5;
            calMin(left, result);
        } else {
            result[0] = result[0] + min;
        }
    }

    private int convertStrToNum(String time) {
        String[] tArr = time.split(":");
        return Integer.parseInt(tArr[0]) * 60 + Integer.parseInt(tArr[1]);
    }
}
