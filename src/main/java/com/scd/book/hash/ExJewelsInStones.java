package com.scd.book.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class ExJewelsInStones {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        int lenj = jewels.length();
        for (int i = 0; i < lenj; i++) {
            jewelSet.add(jewels.charAt(i));
        }
        int lens = stones.length();
        int count = 0;
        for (int i = 0; i < lens; i++) {
            if (jewelSet.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
