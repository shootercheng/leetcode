package com.scd.exercise;

/**
 * @author James
 */
public class Code496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int lens1 = nums1.length;
        int lens2 = nums2.length;
        int[] result = new int[lens1];
        boolean[] find = new boolean[lens1];
        for (int i = 0; i < lens1; i++) {
            for (int j = 0; j < lens2; j++) {
                if (nums1[i] == nums2[j]) {
                    int nextBig = findNextBig(nums2, j, nums1[i]);
                    if (nextBig != -1) {
                        result[i] = nums2[nextBig];
                        find[i] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < lens1; i++) {
            if (!find[i]) {
                result[i] = -1;
            }
        }
        return result;
    }

    public int findNextBig(int[] nums2, int start, int n) {
        int loopStart = start + 1;
        int lens2 = nums2.length;
        for (int i = loopStart; i < lens2; i++) {
            if (n < nums2[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        Code496 code496 = new Code496();
        int[] result = code496.nextGreaterElement(nums1, nums2);
        System.out.println(result);
    }
}
