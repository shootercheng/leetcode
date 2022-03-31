package com.scd.exercise.y2021.m7;

/**
 * @author James
 */
public class Code1812 {
    private static int[] LINE_ONE = {0,1,0,1,0,1,0,1};

    private static int[] LINE_TWO = {1,0,1,0,1,0,1,0};

    private static int[][] DATA = new int[8][8];

    static {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                DATA[i] = LINE_ONE;
            } else {
                DATA[i] = LINE_TWO;
            }
        }
    }

    public boolean squareIsWhite(String coordinates) {
        char[] charArr = coordinates.toCharArray();
        int row = charArr[0] - 'a';
        int col = Integer.valueOf(String.valueOf(charArr[1])) - 1;
        return DATA[row][col] == 1;
    }

    public static void main(String[] args) {
        Code1812 code1812 = new Code1812();
        System.out.println(code1812.squareIsWhite("a1"));
    }
}
