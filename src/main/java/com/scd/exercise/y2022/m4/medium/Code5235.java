package com.scd.exercise.y2022.m4.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 5235. 找出输掉零场或一场比赛的玩家
 * @author James
 */
public class Code5235 {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winCountMap = new HashMap<>();
        Map<Integer, Integer> loseCountMap = new HashMap<>();
        Set<Integer> players = new HashSet<>();
        for (int[] match : matches) {
            int count = winCountMap.computeIfAbsent(match[0], k -> 0);
            winCountMap.put(match[0], ++count);
            int loseCount = loseCountMap.computeIfAbsent(match[1], k -> 0);
            loseCountMap.put(match[1], ++loseCount);
            players.add(match[0]);
            players.add(match[1]);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> winList = new ArrayList<>();
        List<Integer> loseList = new ArrayList<>();
        for (Integer player : players) {
            if (winCountMap.containsKey(player) && !loseCountMap.containsKey(player)) {
                winList.add(player);
            }
            Integer loseCount = loseCountMap.get(player);
            if (loseCount != null && loseCount == 1) {
                loseList.add(player);
            }
        }
        winList = winList.stream().sorted().collect(Collectors.toList());
        loseList = loseList.stream().sorted().collect(Collectors.toList());
        resultList.add(winList);
        resultList.add(loseList);
        return resultList;
    }
}
