package com.scd.contest.week257;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code5864 {
    public int numberOfWeakCharacters(int[][] properties) {
        int len = properties.length;
        Set<Integer> keys = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int[] propi = properties[i];
                int[] propj = properties[j];
                boolean compareji = propj[0] > propi[0] && propj[1] > propi[1];
                boolean compareij = propi[0] > propj[0] && propi[1] > propj[1];
                if (compareji) {
                    keys.add(i);
                    continue;
                }
                if (compareij) {
                    keys.add(j);
                    continue;
                }
            }
        }
        return keys.size();
    }

    public static void main(String[] args) {
        int[][] prop = {{7,7},{1,2},{9,7},{7,3},{3,10},{9,8},{8,10},{4,3},{1,5},{1,5}};
        Code5864 code5864 = new Code5864();
        System.out.println(code5864.numberOfWeakCharacters(prop));
    }
}
