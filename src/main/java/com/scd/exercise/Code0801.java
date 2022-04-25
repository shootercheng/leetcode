package com.scd.exercise;

import java.math.BigInteger;

/**
 * @author James
 */
public class Code0801 {

    public int waysToStep(int n) {
        BigInteger mod = new BigInteger("1000000007");
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            BigInteger[] records = new BigInteger[n + 1];
            records[1] = new BigInteger("1");
            records[2] = new BigInteger("2");
            records[3] = new BigInteger("4");
            for (int i = 4; i <= n; i++) {
                records[i] = records[i - 3].add(records[i - 2]).add(records[i - 1]);
            }
            return records[n].mod(mod).intValue();
        }
    }

    public static void main(String[] args) {
        Code0801 code0801 = new Code0801();
        code0801.waysToStep(100000);
    }
}
