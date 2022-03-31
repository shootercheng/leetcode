package com.scd.contest.week244;

/**
 * @author James
 */
public class Code5776 {

    public int[][] rotate(int[][] mat) {
        int[][] temp = new int[mat.length][mat[0].length];
        int lenm = mat.length;
        for (int i = 0; i < lenm; i++) {
            for (int j = 0; j < lenm; j++) {
                temp[j][lenm - 1- i] = mat[i][j];
            }
        }
        return temp;
    }

    public boolean isEqual(int[][] mat, int[][] target) {
        int lenm = mat.length;
        for (int i = 0; i < lenm; i++) {
            for (int j = 0; j < lenm; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int lenm = mat.length;
        int lent = target.length;
        if (lenm != lent) {
            return false;
        }
        if (isEqual(mat, target)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int[][] temp = rotate(mat);
            if (isEqual(temp, target)) {
                return true;
            }
            mat = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] target = {{1,1,1},{0,1,0},{0,0,0}};
        Code5776 code5776 = new Code5776();
        System.out.println(code5776.findRotation(mat, target));
    }
}
