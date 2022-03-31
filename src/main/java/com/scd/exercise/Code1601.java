package com.scd.exercise;

/**
 * @author James
 */
public class Code1601 {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
//        int a = 1;
//        int b = 2;
//        a = a + b;
//        b = a - b;
//        a = a - b;
        int[] numbers = {0,1};
        Code1601 code1601 = new Code1601();
        code1601.swapNumbers(numbers);
        System.out.println(numbers);

    }
}
