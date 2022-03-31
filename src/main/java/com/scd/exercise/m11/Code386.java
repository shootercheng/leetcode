package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code386 {

    public List<Integer> lexicalOrder(int n) {
        List<String> strList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            strList.add(String.valueOf(i));
        }
        strList = strList.stream().sorted().collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();
        for (String str : strList) {
            resultList.add(Integer.parseInt(str));
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3","4","5","10","11","12","13","14");
        List<String> resultList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(resultList);
    }
}
