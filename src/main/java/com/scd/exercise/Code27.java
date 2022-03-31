package com.scd.exercise;

/**
 * @author James
 */
public class Code27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        int i = 0;
        int removeNum = 0;
        while ((i + removeNum) < len) {
            int curNum = nums[i];
            if (curNum == val) {
                for (int k = i; k < len - 1; k++) {
                    nums[k] = nums[k+1];
                }
                nums[len - 1] = 0;
                removeNum++;
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] num = new int[]{3,2,2,3};
        Code27 code27 = new Code27();
        int res = code27.removeElement(num, 3);
        System.out.println(res);
    }
}
