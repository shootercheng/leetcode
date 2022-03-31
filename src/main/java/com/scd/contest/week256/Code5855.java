package com.scd.contest.week256;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author James
 */
public class Code5855 {

    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, this::compareNum);
        int lenn = nums.length;
        int index = lenn - k;
        return nums[index];
    }

    public int compareNum(String num1, String num2) {
        return new BigInteger(num1).compareTo(new BigInteger(num2));
    }

    public static void main(String[] args) {
        Code5855 code5855 = new Code5855();
        String[] nums = {"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};
        System.out.println(code5855.kthLargestNumber(nums, 11));
    }
}
