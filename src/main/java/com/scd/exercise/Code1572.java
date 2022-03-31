package com.scd.exercise;

/**
 * @author James
 */
public class Code1572 {

    public int diagonalSum(int[][] mat) {
        int len = mat.length;
        boolean[][] used = new boolean[len][len];
        int sum = 0;
        for (int i = 0, j = 0; i < len; i++, j++) {
            used[i][j] = true;
            sum = sum + mat[i][j];
        }
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            if (!used[i][j]) {
                used[i][j] = true;
                sum = sum + mat[i][j];
            }
        }
        return sum;
    }

    public int diagonalSum2(int[][] mat) {
        int len = mat.length;
        int sum = 0;
        boolean isEvenNum = len % 2 != 0;
        int center = len / 2;
        for (int i = 0, j = 0; i < len; i++, j++) {
            sum = sum + mat[i][j];
        }
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            if (isEvenNum && i == center && j == center) {
                continue;
            }
            sum = sum + mat[i][j];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        Code1572 code1572 = new Code1572();
        code1572.diagonalSum(mat);
    }
}
