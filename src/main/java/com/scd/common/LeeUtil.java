package com.scd.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class LeeUtil {

    /**
     * 转换为二维数组
     *
     * @param inputStr [[9,1,53],[3,2,66],[12,5,99],[9,7,26],[1,4,78],[11,1,62],[3,10,50],[12,1,71],[12,6,63],[1,10,63],[9,10,88],[9,11,59],[1,4,37],[4,2,63],[0,2,26],[6,12,98],[9,11,99],[4,5,40],[2,8,25],[4,2,35],[8,10,9],[11,9,25],[10,11,11],[7,6,89],[2,4,99],[10,4,63]]
     * @return int[][]
     */
    public int[][] strToInt(String inputStr) {
        List<List<Integer>> dataList = new ArrayList<>();
        int max = 0;
        int firstIndex = inputStr.indexOf("[");
        int tempIndex = firstIndex;
        while (tempIndex < inputStr.length() - 2) {
            int nextIndex = inputStr.indexOf("[", tempIndex + 1);
            if (nextIndex == - 1) {
                break;
            }
            int rightNextIndex = 0;
            while (true) {
                rightNextIndex = inputStr.indexOf("]",  nextIndex + 1);
                if (rightNextIndex != -1) {
                    break;
                }
            }
            String subStr = inputStr.substring(nextIndex + 1, rightNextIndex);
            String[] subArr = subStr.split(",");
            List<Integer> subList = new ArrayList<>();
            for (String ele : subArr) {
                subList.add(Integer.parseInt(ele));
            }
            if (subList.size() > max) {
                max = subList.size();
            }
            dataList.add(subList);
            tempIndex = rightNextIndex + 1;
        }
        int dSize = dataList.size();
        int[][] result = new int[dSize][max];
        for (int i = 0; i < dSize; i++) {
            int subSize = dataList.get(i).size();
            for (int j = 0; j < subSize; j++) {
                result[i][j] = dataList.get(i).get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeeUtil leeUtil = new LeeUtil();
        System.out.println(
                Arrays.toString(leeUtil.strToInt("[[9,1,53],[3,2,66],[12,5,99],[9,7,26],[1,4,78],[11,1,62],[3,10,50],[12,1,71],[12,6,63],[1,10,63],[9,10,88],[9,11,59],[1,4,37],[4,2,63],[0,2,26],[6,12,98],[9,11,99],[4,5,40],[2,8,25],[4,2,35],[8,10,9],[11,9,25],[10,11,11],[7,6,89],[2,4,99],[10,4,63]]")));
    }
}
