package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1656 {

    static class OrderedStream {
        private String[] orderedArr;

        private int ptr = 1;

        public OrderedStream(int n) {
            orderedArr = new String[n];
        }

        public List<String> insert(int id, String value) {
            List<String> result = new ArrayList<>();
            int len = orderedArr.length;
            if (id > len) {
                return result;
            }
            orderedArr[id - 1] = value;
            if (id <= ptr) {
                for (int i = ptr - 1; i < len; i++) {
                    if (orderedArr[i] == null) {
                       break;
                    }
                    result.add(orderedArr[i]);
                    ptr++;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        OrderedStream os= new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));      // 插入 (3, "ccccc")，返回 []
        System.out.println(os.insert(1, "aaaaa"));      // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(os.insert(2, "bbbbb"));      // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(os.insert(5, "eeeee"));      // 插入 (5, "eeeee")，返回 []
        System.out.println(os.insert(4, "ddddd"));      // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]

    }
}
