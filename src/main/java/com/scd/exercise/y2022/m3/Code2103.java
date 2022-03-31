package com.scd.exercise.y2022.m3;

/**
 * @author James
 */
public class Code2103 {

    public int countPoints(String rings) {
        int[][] record = new int[10][3];
        int lenr = rings.length();
        for (int i = 0; i < lenr; i = i + 2) {
            char col = rings.charAt(i);
            char row = rings.charAt(i+1);
            int rowNum = row - 48;
            if (col == 'R') {
                record[rowNum][0] = 1;
            } else if (col == 'G') {
                record[rowNum][1] = 1;
            } else if (col == 'B') {
                record[rowNum][2] = 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (record[i][0] == 1 && record[i][1] == 1
                    && record[i][2] == 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char num = '0';
        int nnum = num - 48;
        System.out.println(nnum);
    }
}
