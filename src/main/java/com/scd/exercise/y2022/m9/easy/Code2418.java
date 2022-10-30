package com.scd.exercise.y2022.m9.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 按身高排序
 */
public class Code2418 {

    class User {
        private String name;

        private int height;

        public User(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public int getHeight() {
            return height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        if (names.length != heights.length) {
            throw new IllegalArgumentException("input arr length not equal");
        }
        int lenn = names.length;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < lenn; i++) {
            userList.add(new User(names[i], heights[i]));
        }
        userList = userList.stream().sorted(Comparator.comparing(User::getHeight).reversed())
                .collect(Collectors.toList());
        String[] result = new String[lenn];
        for (int i = 0; i < lenn; i++) {
            result[i] = userList.get(i).name;
        }
        return result;
    }
}
