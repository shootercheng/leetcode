package com.scd.contest;

import java.util.Stack;

/**
 * @author James
 */
public class Code5614_1 {

    public int[] mostCompetitive(int[] nums, int k) {
        int[] result = new int[k];
        int lenn = nums.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for (int i = 1; i < lenn; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                // 判断弹出之后数据是否有 k 个
                // 栈的大小 + 剩下的数据长度小于 k， 就不能弹出了
                if (stack.size() + lenn - 1 - i < k) {
                    break;
                }
                stack.pop();
            }
            if (stack.size() < k) {
                stack.add(nums[i]);
            }
        }
        int index = k - 1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Code5614_1 code5614_1 = new Code5614_1();
//        System.out.println(code5614_1.mostCompetitive(new int[]{4,3,2,1}, 2));
//        System.out.println(code5614_1.mostCompetitive(new int[]{1,2,3,4}, 2));
//        [2,4,3,3,5,4,9,6]
//        4
        System.out.println(code5614_1.mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4));
    }
}
