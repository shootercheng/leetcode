package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (numRows <= 0) {
            return resultList;
        } else if (numRows == 1) {
            resultList.add(Arrays.asList(1));
        } else if (numRows == 2) {
            resultList.add(Arrays.asList(1));
            resultList.add(Arrays.asList(1,1));
        } else {
            resultList.add(Arrays.asList(1));
            resultList.add(Arrays.asList(1,1));
            for (int i = 2; i < numRows; i++) {
                List<Integer> curRow = new ArrayList<>();
                curRow.add(1);
                for (int j = 1; j < i; j++) {
                    List<Integer> previousList = resultList.get(i - 1);
                    int calNum = previousList.get(j - 1) + previousList.get(j);
                    curRow.add(calNum);
                }
                curRow.add(1);
                resultList.add(curRow);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Code118 code118 = new Code118();
        System.out.println(code118.generate(3));
    }
}
