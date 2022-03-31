package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code80 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int remove = 0;
        int count = 1;
        int temp = nums[0];
        for (int i = 1; i < len; i++) {
            if (i == len - remove) {
                break;
            }
            if (temp == nums[i]) {
                if (++count > 2) {
                    moveCurToEnd(i, len, nums);
                    count--;
                    remove++;
                    i--;
                }
            } else {
                temp = nums[i];
                count = 1;
            }
        }
        return len - remove;
    }

    private void moveCurToEnd(int i, int len, int[] nums) {
        int temp = nums[i];
        for (int j = i; j < len - 1; j++) {
            nums[j] = nums[j+1];
        }
        nums[len - 1] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2,3};
        Code80 code80 = new Code80();
//        System.out.println(code80.removeDuplicates(nums));
        System.out.println(code80.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3,3}));
    }
}
