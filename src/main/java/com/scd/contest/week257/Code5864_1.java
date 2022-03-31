package com.scd.contest.week257;

import java.util.Arrays;

/**
 * @author James
 */
public class Code5864_1 {

    public int numberOfWeakCharacters(int[][] properties) {
        int len = properties.length;
        Arrays.sort(properties, this::compareNum);
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (properties[j][0] > properties[i][0] && properties[j][1] > properties[i][1]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int compareNum(int[] prop1, int[] prop2) {
        return prop1[0] - prop2[0];
    }

    public static void main(String[] args) {
        int[][] prop = {{7,7},{1,2},{9,7},{7,3},{3,10},{9,8},{8,10},{4,3},{1,5},{1,5}};
        Code5864_1 code5864 = new Code5864_1();
        System.out.println(code5864.numberOfWeakCharacters(prop));
    }
}
