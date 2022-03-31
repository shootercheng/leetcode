package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1352 {

    static class ProductOfNumbers {
        private List<Integer> nums;

        private int temp = 1;

        public ProductOfNumbers() {
            nums = new ArrayList<>();
            nums.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                nums = new ArrayList<>();
                nums.add(1);
            } else {
                nums.add(nums.get(nums.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            int startIndex = nums.size() - k - 1;
            if (startIndex == -1) {
                return 0;
            }
            return nums.get(nums.size() - 1) / nums.get(startIndex);
        }
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3)); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4)); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
        // [0,5,6,8]
    }
}
