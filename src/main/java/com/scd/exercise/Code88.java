package com.scd.exercise;

/**
 * @author James
 */
public class Code88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] result = new int[m + n];
//        System.arraycopy(nums1,0, result,0, m);
        if (n <= 0) {
            return ;
        }
        int start = 0;
        int maxIndex = -1;
        int zeroIndex = m;
        int nums1Len = nums1.length;
        for (int i = 0; i < n; i++) {
            start = findLessIndex(nums1, nums1Len, start, nums2[i]);
            if (start != -1) {
                for (int j = nums1Len - 1; j > start; j--) {
                    nums1[j] = nums1[j - 1];
                }
                nums1[start] = nums2[i];
                zeroIndex++;
            } else {
                maxIndex = i;
                break;
            }
        }
        if (maxIndex != -1) {
            for (int i = maxIndex; i < n; i++) {
                nums1[zeroIndex++] = nums2[i];
            }
        }
    }

    public int findLessIndex(int[] num, int nums1Len, int start, int curNum) {
        for (int i = start; i < nums1Len; i++) {
            if (curNum < num[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Code88 code88 = new Code88();
        int[] nums1 = new int[]{2, 0};
        code88.merge(nums1, 1, new int[]{1}, 1);
        System.out.println(nums1);
    }
}
