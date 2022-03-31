package com.scd.exercise.y2021.m7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> tableOrderMap = new HashMap<>();
        Set<String> footSet = new HashSet<>();
        Set<Integer> tableSet = new HashSet<>();
        for (List<String> order : orders) {
            String table = order.get(1);
            String footItem = order.get(2);
            footSet.add(footItem);
            tableSet.add(Integer.parseInt(table));
            Map<String,Integer> orderMap = tableOrderMap.computeIfAbsent(table, k -> new HashMap<>());
            Integer count = orderMap.computeIfAbsent(footItem, k -> 0);
            orderMap.put(footItem, ++count);
        }
        List<String> footList = new ArrayList<>(footSet);
        footList = footList.stream().sorted().collect(Collectors.toList());
        List<String> finalFootList = footList;
        List<List<String>> result = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        titleList.add("Table");
        titleList.addAll(footList);
        result.add(titleList);
        List<Integer> tables = new ArrayList<>(tableSet);
        tables = tables.stream().sorted().collect(Collectors.toList());
        for (Integer table : tables) {
            String key = String.valueOf(table);
            List<String> tableList = new ArrayList<>();
            tableList.add(key);
            Map<String, Integer> value = tableOrderMap.get(key);
            for (String footItem : finalFootList) {
                Integer count = value.get(footItem);
                if (count != null) {
                    tableList.add(String.valueOf(count));
                } else {
                    tableList.add("0");
                }
            }
            result.add(tableList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("David","3","Ceviche");
        List<String> list2 = Arrays.asList("Corina","10","Beef Burrito");
        List<String> list3 = Arrays.asList("David","3","Fried Chicken");
        List<List<String>> dataList = new ArrayList<>();
        dataList.add(list1);
        dataList.add(list2);
        dataList.add(list3);
        Code1418 code1418 = new Code1418();
        System.out.println(code1418.displayTable(dataList));
    }
}
