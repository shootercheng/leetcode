package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1437 {

    public boolean kLengthApart(int[] nums, int k) {
        int lenn = nums.length;
        int pre = findOneIndex(nums, lenn, 0);
        while (true) {
            int next = findOneIndex(nums, lenn, pre + 1);
            if (next == -1) {
                break;
            }
            if (next - pre <= k) {
                return false;
            }
            pre = next;
        }
        return true;
    }

    public int findOneIndex(int[] nums, int len, int startIndex) {
        for (int i = startIndex; i < len; i++) {
            if (nums[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,1,0,0,1};
        Code1437 code1437 = new Code1437();
        System.out.println(code1437.kLengthApart(nums, 2));
    }
}
