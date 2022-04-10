package com.scd.contest.week288;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code6037 {

    public int largestInteger(int num) {
        List<Integer> numList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (num > 9) {
            int curNum = num % 10;
            if (curNum % 2 == 0) {
                list2.add(curNum);
            } else {
                list1.add(curNum);
            }
            numList.add(curNum);
            num = num / 10;
        }
        if (num % 2 == 0) {
            list2.add(num);
        } else {
            list1.add(num);
        }
        numList.add(num);
        list1 = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        list2 = list2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int index1 = 0;
        int index2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = numList.size() - 1; i >= 0; i--) {
            if (numList.get(i) % 2 == 0) {
                stringBuilder.append(list2.get(index2++));
            } else {
                stringBuilder.append(list1.get(index1++));
            }
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        Code6037 code6037 = new Code6037();
        code6037.largestInteger(247);
    }
}
