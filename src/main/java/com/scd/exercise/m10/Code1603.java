package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code1603 {

    class ParkingSystem {
        private int big;

        private int medium;

        private int small;

        private static final int BIG_CAR_TYPE = 1;

        private static final int MEDIUM_CAR_TYPE = 2;

        private static final int SMALL_CAR_TYPE = 3;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case BIG_CAR_TYPE:
                    if (big <= 0) {
                        return false;
                    }
                    big--;
                    return true;
                case MEDIUM_CAR_TYPE:
                    if (medium <= 0) {
                        return false;
                    }
                    medium--;
                    return true;
                case SMALL_CAR_TYPE:
                    if (small <= 0) {
                        return false;
                    }
                    small--;
                    return false;
                default:
                    return false;

            }
        }
    }
}
