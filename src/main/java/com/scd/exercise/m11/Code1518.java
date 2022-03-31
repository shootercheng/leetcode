package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        int newBottle = numBottles / numExchange;
        sum = sum + newBottle;
        int leftBottle = numBottles % numExchange + newBottle;
        while (leftBottle >= numExchange) {
            newBottle = leftBottle / numExchange;
            sum = sum + newBottle;
            leftBottle = leftBottle % numExchange + newBottle;
        }
        return sum;
    }

    public static void main(String[] args) {
        Code1518 code1518 = new Code1518();
        System.out.println(code1518.numWaterBottles(2,3));
    }
}
