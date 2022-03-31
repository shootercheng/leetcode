package com.scd.contest;

import java.math.BigInteger;

/**
 * @author James
 */
public class Code5762 {

    public int arraySign(int[] nums) {
        BigInteger bigInteger = new BigInteger("1");
        BigInteger zero = new BigInteger("0");
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            BigInteger curInt = new BigInteger(String.valueOf(num));
            bigInteger = bigInteger.multiply(curInt);
        }
        return bigInteger.compareTo(zero);
    }
}
