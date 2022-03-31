package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code628 {

    public int maximumProduct(int[] nums) {
        int twoMax = Integer.MIN_VALUE;
        int lenn = nums.length;
        int num1Index = -1;
        int num2Index = -1;
        for (int i = 0; i < lenn; i++) {
            for (int j = 0; j < lenn; j++) {
                if (i != j) {
                    int multi = nums[i] * nums[j];
                    if (multi > twoMax) {
                        twoMax = multi;
                        num1Index = i;
                        num2Index = j;
                    }
                }
            }
        }
        int thrid = Integer.MIN_VALUE;
        int num3Index = -1;
        for (int i = 0; i < lenn; i++) {
            if (i == num1Index || i == num2Index) {
                continue;
            }
            if (nums[i] > thrid) {
                thrid = nums[i];
                num3Index = i;
            }
        }
        System.out.println(num1Index + " " + num2Index + " " + num3Index);
        System.out.println(nums[num1Index] + " " + nums[num2Index] + " " + nums[num3Index]);
        return twoMax * thrid;
    }

    public int maximumProduct2(int[] nums) {
        int lenn = nums.length;
        int max = Integer.MIN_VALUE;
        int one = -1;
        int two = -1;
        int three = -1;
        for (int i = 0; i < lenn; i++) {
            for (int j = 0; j < lenn; j++) {
                for (int k = 0; k < lenn; k++) {
                    if (i != j && j != k && i != k) {
                        int muiti = nums[i] * nums[j] * nums[k];
                        if (muiti > max) {
                            max = muiti;
                            one = i;
                            two = j;
                            three = k;
                        }
                    }
                }
            }
        }
        System.out.println(one + " " + two + " " + three);
        System.out.println(nums[one] + " " + nums[two] + " " + nums[three]);
        return max;
    }

    public int maximumProduct3(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            if (nums[i] >= 0) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        list1 = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        list2 = list2.stream().sorted().collect(Collectors.toList());
        int list1Size = list1.size();
        int list2Size = list2.size();
        if (list1Size >= 3) {
            if (list2Size >= 2) {
                int max1 = list1.get(0) * list1.get(1) * list1.get(2);
                int max2 = list1.get(0) * list2.get(0) * list2.get(1);
                if (max1 > max2) {
                    return max1;
                } else {
                    return max2;
                }
            } else {
                return list1.get(0) * list1.get(1) * list1.get(2);
            }
        } else {
            if (list2Size >= 2) {
                if (list1Size > 0) {
                    return list1.get(0) * list2.get(0) * list2.get(1);
                } else {
                    if (list2Size >= 3) {
                        return list2.get(list2Size - 1) * list2.get(list2Size - 2) * list2.get(list2Size - 3);
                    }
                }
            } else {
                if (list1Size >= 2 && list2Size >= 1) {
                    return list1.get(0) * list1.get(1) * list2.get(0);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786};
        Code628 code628 = new Code628();
        System.out.println(code628.maximumProduct(nums));
        System.out.println(code628.maximumProduct2(nums));
    }
}
