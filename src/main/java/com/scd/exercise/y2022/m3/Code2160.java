package com.scd.exercise.y2022.m3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code2160 {

    public int minimumSum(int num) {
        List<String> list = new ArrayList<>();
        while (num > 0) {
            list.add(String.valueOf(num % 10));
            num = num / 10;
        }
        list = list.stream().sorted().collect(Collectors.toList());
        int new1 = Integer.parseInt(list.get(0) + list.get(2));
        int new2 = Integer.parseInt(list.get(1) + list.get(3));
        return new1 + new2;
    }
}
