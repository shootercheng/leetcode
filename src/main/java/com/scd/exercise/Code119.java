package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code119 {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        if (rowIndex == 1) {
            return Arrays.asList(1,1);
        }
        List<List<Integer>> recordList = new ArrayList<>();
        recordList.add(Arrays.asList(1));
        recordList.add(Arrays.asList(1,1));
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j <= i - 1; j++) {
                List<Integer> previousRecord = recordList.get(i - 1);
                Integer curNum = previousRecord.get(j - 1) + previousRecord.get(j);
                row.add(curNum);
            }
            row.add(1);
            recordList.add(row);
        }
        return recordList.get(rowIndex);
    }

    public static void main(String[] args) {
        Code119 code119 = new Code119();
        List<Integer> result = code119.getRow(3);
        System.out.println(result);
    }
}
