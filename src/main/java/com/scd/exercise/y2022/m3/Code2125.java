package com.scd.exercise.y2022.m3;

/**
 * @author James
 */
public class Code2125 {

    public int numberOfBeams(String[] bank) {
        int sum = 0;
        int pre = 0;
        for (String row : bank) {
            int count = countVal(row);
            if (count == 0) {
                continue;
            }
            if (pre != 0) {
                sum = sum + pre * count;
            }
            pre = count;
        }
        return sum;
    }

    public int countVal(String row) {
        char[] rowArr = row.toCharArray();
        int count = 0;
        for (char num : rowArr) {
            if (num == '1') {
                count++;
            }
        }
        return count;
    }
}
