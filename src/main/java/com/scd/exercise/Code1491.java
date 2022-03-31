package com.scd.exercise;

import java.math.BigDecimal;


/**
 * @author James
 */
public class Code1491 {

    public double average(int[] salary) {
        int lens = salary.length;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < lens; i++) {
            if (salary[i] > max) {
                max = salary[i];
                maxIndex = i;
            }
            if (salary[i] < min) {
                min = salary[i];
                minIndex = i;
            }
        }
        int sum = 0;
        for (int i = 0; i < lens; i++) {
            if (i == maxIndex || i == minIndex) {
                continue;
            }
            sum = sum + salary[i];
        }
        BigDecimal bigDecimal = new BigDecimal(sum);
        BigDecimal result = bigDecimal.divide(new BigDecimal(lens - 2), 4, BigDecimal.ROUND_HALF_DOWN);
        return result.doubleValue();
    }

    public static void main(String[] args) {
        int[] salary = {48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
        Code1491 code1491 = new Code1491();
        double result = code1491.average(salary);
        System.out.print(result);
    }
}
