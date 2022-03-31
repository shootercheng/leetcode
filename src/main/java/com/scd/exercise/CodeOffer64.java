package com.scd.exercise;

/**
 * @author James
 */
public class CodeOffer64 {

    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums(n -1);
    }

    public static void main(String[] args) {
        CodeOffer64 codeOffer64 = new CodeOffer64();
        int res = (1 + 15) * 15 / 2;
        System.out.println(res);
        System.out.println(codeOffer64.sumNums(100));
    }
}
