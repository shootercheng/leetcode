package com.scd.exercise.y2022.m3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 2078. 两栋颜色不同且距离最远的房子
 * @author James
 */
public class Code2078 {

    public int maxDistance(int[] colors) {
        int lenc = colors.length;
        Map<Integer, List<Integer>> charMap = new HashMap<>();
        for (int i = 0; i < lenc; i++) {
            List<Integer> indexList = charMap.computeIfAbsent(colors[i], k -> new ArrayList<>());
            indexList.add(i);
        }
        Set<Integer> colorSet = charMap.keySet();
        int max = Integer.MIN_VALUE;
        for (Integer c1 : colorSet) {
            for (Integer c2 : colorSet) {
                if (c1.equals(c2)) {
                    continue;
                }
                List<Integer> c1List = charMap.get(c1);
                List<Integer> c2List = charMap.get(c2);
                int cur1 = Math.abs(c1List.get(c1List.size() - 1) - c2List.get(0));
                int cur2 = Math.abs(c2List.get(c2List.size() - 1) - c1List.get(0));
                int cur = Math.max(cur1, cur2);
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Code2078 code2078 = new Code2078();
        code2078.maxDistance(new int[]{4,4,4,11,4,4,11,4,4,4,4,4});
    }
}
