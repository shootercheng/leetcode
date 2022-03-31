package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code682 {

    public int calPoints(String[] ops) {
        List<Integer> resultList = new ArrayList<>();
        for (String str : ops) {
            int last = resultList.size() - 1;
            switch(str) {
                case "+":
                    resultList.add(resultList.get(last) + resultList.get(last - 1));
                    break;
                case "D":
                    resultList.add(resultList.get(last) * 2);
                    break;
                case "C":
                    resultList.remove(last);
                    break;
                default:
                    resultList.add(Integer.parseInt(str));
            }
        }
        int sum = 0;
        for (Integer source : resultList) {
            sum = sum + source;
        }
        return sum;
    }
}
