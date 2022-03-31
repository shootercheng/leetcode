package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> nameIndexListMap = new HashMap<>();
        int lena = accounts.size();
        for (int i = 0; i < lena; i++) {
            List<String> accountList = accounts.get(i);
            String name = accountList.get(0);
            List<Integer> indexList = nameIndexListMap.computeIfAbsent(name, k -> new ArrayList<>());
            indexList.add(i);
        }
        List<List<String>> result = new ArrayList<>();
        Set<Map.Entry<String, List<Integer>>> entrySet = nameIndexListMap.entrySet();
        for (Map.Entry<String, List<Integer>> entry : entrySet) {
            List<Integer> indexList = entry.getValue();
            Set<String> emailSet = new HashSet<>();
            for (Integer index : indexList) {
                List<String> curList = accounts.get(index);
                curList.remove(0);
//                for (String )
            }
        }
        return result;
    }
}
