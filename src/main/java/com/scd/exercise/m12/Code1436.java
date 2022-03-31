package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1436 {

    public String destCity(List<List<String>> paths) {
        Map<String, List<String>> startEndMap = new HashMap<>();
        Set<String> allPoint = new HashSet<>();
        for (List<String> list : paths) {
            String start = list.get(0);
            String end = list.get(1);
            List<String> endList = startEndMap.computeIfAbsent(start, k -> new ArrayList<>());
            endList.add(end);
            allPoint.add(start);
            allPoint.add(end);
        }
        for (String point : allPoint) {
            if (!startEndMap.containsKey(point)) {
                return point;
            }
        }
        return "";
    }
}
