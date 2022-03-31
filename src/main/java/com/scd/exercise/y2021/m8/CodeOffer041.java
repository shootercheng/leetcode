package com.scd.exercise.y2021.m8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer041 {

    class MovingAverage {
        private List<Integer> list;

        private int size;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            list = new ArrayList<>(size);
            this.size = size;
        }

        public double next(int val) {
            int curListSize = list.size();
            if (curListSize == size) {
                list.remove(0);
            }
            list.add(val);
            double sum = 0;
            for (Integer num : list) {
                sum = sum + num;
            }
            return sum / list.size();
        }
    }
}
