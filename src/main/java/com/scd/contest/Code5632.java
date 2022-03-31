package com.scd.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code5632 {

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int lene = edgeList.length;
        Map<String, Integer> disMap = new HashMap<>();
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        for (int i = 0; i < lene; i++) {
            int start = edgeList[i][0];
            int end = edgeList[i][1];
            disMap.put(start + "_" + end, edgeList[i][2]);
            List<Integer> endList = graphMap.computeIfAbsent(start, k -> new ArrayList<>());
            endList.add(end);
        }
        int lenq = queries.length;
        boolean[] result = new boolean[lenq];
        for (int i = 0; i < lenq; i++) {
            boolean res = isLimitPath(disMap, graphMap, queries[i]);
            result[i] = res;
        }
        return result;
    }

    private boolean isLimitPath(Map<String, Integer> disMap, Map<Integer, List<Integer>> graphMap, int[] query) {
        int start = query[0];
        int end = query[1];
        int limit = query[2];
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> onePath = new ArrayList<>();
        Set<String> rpPath = new HashSet<>();
        findPath(graphMap, paths, onePath, start, end, rpPath);
        if (paths.size() > 0) {
            for (List<Integer> path : paths) {
                int startPoint = path.get(0);
                int pSize = path.size();
                boolean isOver = false;
                for (int i = 1; i < pSize; i++) {
                    int nextPoint = path.get(i);
                    int dis = disMap.get(startPoint + "_" + nextPoint);
                    if (dis >= limit) {
                        isOver = true;
                        break;
                    }
                    startPoint = nextPoint;
                }
                if (!isOver) {
                    return true;
                }
            }
        }
        return false;
    }

    private void findPath(Map<Integer, List<Integer>> graphMap,
                          List<List<Integer>> paths, List<Integer> onePath, int start, int end, Set<String> rpPath) {
        onePath.add(start);
        if (start == end) {
            paths.add(onePath);
        } else {
            List<Integer> targetList = graphMap.get(start);
            if (targetList != null && targetList.size() > 0) {
                for (Integer target : targetList) {
                    String path = start < target ? start + "_" + target : target + "_" + start;
                    if (!rpPath.contains(path)) {
                        rpPath.add(path);
                    } else {
                        return;
                    }
                    findPath(graphMap, paths, new ArrayList<>(onePath), target, end, rpPath);
                }
            }
        }
    }

    public static void main(String[] args) {
        Code5632 code5632 = new Code5632();
        int[][] edgeList = {
                {0,1,2},
                {1,2,4},
                {2,0,8},
                {1,0,16}
        };
        int[][] queries = {
                {0,1,2},
                {0,2,5}
        };
        code5632.distanceLimitedPathsExist(3, edgeList, queries);
//        int[][] edgeList = {
//                {0, 1, 10},
//                {1, 2, 5},
//                {2, 3, 9},
//                {3, 4, 13}
//        };
//        int[][] queries = {
//                {0, 4, 14},
//                {1, 4, 13}
//        };
//        code5632.distanceLimitedPathsExist(5, edgeList, queries);
    }
}
