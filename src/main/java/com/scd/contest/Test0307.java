package com.scd.contest;

/**
 * @author James
 */
public class Test0307 {

    public boolean checkOnesSegment(String s) {
        int zeroIndex = s.indexOf("0");
        if (zeroIndex == -1) {
            return true;
        }
        char[] sArr = s.toCharArray();
        int lens = sArr.length;
        boolean before = false;
        for (int i = 0; i < zeroIndex; i++) {
            if (sArr[i] == '1') {
                before = true;
                break;
            }
        }
        boolean after = false;
        for (int i = zeroIndex + 1; i < lens; i++) {
            if (sArr[i] == '1') {
                after = true;
                break;
            }
        }
        if (before && after) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Test0307 test0307 = new Test0307();
        System.out.println(test0307.checkOnesSegment("1100111"));
    }
}
