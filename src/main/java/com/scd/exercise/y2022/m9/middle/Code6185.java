package com.scd.exercise.y2022.m9.middle;

import java.util.Arrays;

/**
 * 6185. 运动员和训练师的最大匹配数
 * @author James
 */
public class Code6185 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int pIndex = 0;
        int tIndex = 0;
        int count = 0;
        while (pIndex < players.length && tIndex < trainers.length) {
            int findIndex = match(pIndex, tIndex, players, trainers);
            if (findIndex == -1) {
                break;
            }
            pIndex++;
            tIndex = ++findIndex;
            count++;
        }
        return count;
    }

    private int match(int pIndex, int tIndex, int[] players, int[] trainers) {
        while (pIndex < players.length && tIndex < trainers.length) {
            if (players[pIndex] <= trainers[tIndex]) {
                return tIndex;
            }
            tIndex++;
        }
        return -1;
    }

    public static void main() {

    }
}
