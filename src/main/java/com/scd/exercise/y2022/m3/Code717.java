package com.scd.exercise.y2022.m3;

/**
 * @author James
 */
public class Code717 {

    public boolean isOneBitCharacter(int[] bits) {
        int lenb = bits.length;
        int i = 0;
        while (i < lenb) {
            if (bits[i] == 1) {
                i = i + 2;
            } else {
                if (i == lenb - 1) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
