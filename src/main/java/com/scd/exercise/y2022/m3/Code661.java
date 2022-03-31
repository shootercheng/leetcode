package com.scd.exercise.y2022.m3;

/**
 * 661 图片平滑器
 * @author James
 */
public class Code661 {
    public int[][] imageSmoother(int[][] M) {
        int lenm = M.length;
        int lenn = M[0].length;
        int[][] result = new int[lenm][lenn];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                result[i][j] = calMPoint(i, j, M);
            }
        }
        return result;
    }

    private int calMPoint(int i, int j, int[][] m) {
        int up = i - 1;
        int down = i + 1;
        int left = j - 1;
        int right = j + 1;
        int sum = 0;
        int count = 0;
        if (left >= 0) {
            count++;
            sum = sum + m[i][left];
            if (up >= 0) {
                count++;
                sum = sum + m[up][left];
            }
            if (down < m.length) {
                count++;
                sum = sum + m[down][left];
            }
        }
        if (right < m[i].length ) {
            count++;
            sum = sum + m[i][right];
            if (up >= 0) {
                sum = sum + m[up][right];
                count++;
            }
            if (down < m.length) {
                sum = sum + m[down][right];
                count++;
            }
        }
        if (up >= 0) {
            count++;
            sum = sum + m[up][j];
        }
        if (down < m.length) {
            count++;
            sum = sum + m[down][j];
        }
        sum = sum + m[i][j];
        count++;
        return sum / count;
    }

    public static void main(String[] args) {
        int[][] m = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        Code661 code661 = new Code661();
        code661.imageSmoother(m);
    }
}
