package com.scd.exercise.y2022.m3;

/**
 *  997. 找到小镇的法官
 *  * @author James
 */
public class Code997_1 {

    public int findJudge(int N, int[][] trust) {
        int[] outN = new int[N + 1];
        int[] intN = new int[N + 1];
        for (int[] tempArr : trust) {
            if (tempArr[0] > N || tempArr[1] > N) {
                return -1;
            }
            intN[tempArr[1]]++;
            outN[tempArr[0]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (intN[i] == N - 1 && outN[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
