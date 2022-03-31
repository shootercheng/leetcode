package com.scd.exercise.y2021.m8;

/**
 * @author James
 */
public class Code1409 {

    public int[] processQueries(int[] queries, int m) {
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = i+1;
        }
        int lenq = queries.length;
        int[] result = new int[lenq];
        for (int i = 0; i < lenq; i++) {
            int curNum = queries[i];
            result[i] = findNumIndex(curNum, mArr);
        }
        return result;
    }

    private int findNumIndex(int curNum, int[] mArr) {
        int index = -1;
        for (int i = 0; i < mArr.length; i++) {
            if (mArr[i] == curNum) {
                index = i;
                break;
            }
        }
        int temp = mArr[index];
        for (int i = index; i > 0; i--) {
            mArr[i] = mArr[i-1];
        }
        mArr[0] = temp;
        return index;
    }

    public static void main(String[] args) {
        int[] queries = {3,1,2,1};
        Code1409 code1409 = new Code1409();
        int[] result = code1409.processQueries(queries, 5);
        System.out.println(result);
    }
}
