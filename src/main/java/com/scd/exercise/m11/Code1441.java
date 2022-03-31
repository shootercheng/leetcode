package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author James
 */
public class Code1441 {
    private static final String L_PUSH = "Push";

    private static final String L_POP = "Pop";

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
//        Stack<Integer> stack = new Stack<>();
        int lent = target.length;
        int j = 1;
        for (int i = 0; i < lent; i++) {
            if (target[i] == j) {
//                stack.push(j);
                list.add(L_PUSH);
                j++;
            } else {
                while (target[i] != j) {
//                    stack.push(j);
                    list.add(L_PUSH);
//                    stack.pop();
                    list.add(L_POP);
                    j++;
                }
//                stack.push(j);
                list.add(L_PUSH);
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Code1441 code1441 = new Code1441();
        int[] target1 = {2,3,4,5,8,9,10};
        System.out.println(code1441.buildArray(target1, 10));
//        int[] target2 = {1,2,3};
//        System.out.println(code1441.buildArray(target2, 3));
//        int[] target3 = {1,2};
//        System.out.println(code1441.buildArray(target3, 4));
    }
}
