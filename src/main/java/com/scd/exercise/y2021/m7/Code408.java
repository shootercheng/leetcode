package com.scd.exercise.y2021.m7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code408 {

    /**
     * 小时数组合
     *  0位 :
     *  1位 : 1,2,4,8
     *  2位 : 1+2, 1+4, 1+8, 2+4, 2+8
     *  3位 ：1+2+4, 1+2+8, 
     *
     *  分钟数组合
     *  0位 :
     *  1位 : 1,2,4,8,16,32
     *  2位 : 1,2、1,4、1,8、1,16、1,32
     *  3位 : 1,2,4、1,2,8、
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if (num > 8) {
            return list;
        }
        return list;
    }
}
