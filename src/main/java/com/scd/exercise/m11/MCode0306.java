package com.scd.exercise.m11;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class MCode0306 {


    class AnimalShelf {

        class AnimalSeq {
            private Integer seq;

            private Integer number;

            public AnimalSeq(Integer seq, Integer number) {
                this.seq = seq;
                this.number = number;
            }
        }

        private static final int CAT_TYPE = 0;

        private static final int DOG_TYPE = 1;

        private final int[] EMPTY_RES = new int[]{-1,-1};

        private Queue<AnimalSeq> catQueue;

        private Queue<AnimalSeq> dogQueue;

        private Integer seq;

        public AnimalShelf() {
            catQueue = new ArrayDeque<>();
            dogQueue = new ArrayDeque<>();
            seq = 0;
        }

        public void enqueue(int[] animal) {
            int number = animal[0];
            int type = animal[1];
            if (type == CAT_TYPE) {
                catQueue.offer(new AnimalSeq(seq++, number));
            } else if (type == DOG_TYPE) {
                dogQueue.offer(new AnimalSeq(seq++, number));
            }

        }

        public int[] dequeueAny() {
            AnimalSeq catAnimal = catQueue.peek();
            AnimalSeq dogAnimal = dogQueue.peek();
            if (catAnimal == null && dogAnimal == null) {
                return EMPTY_RES;
            } else if (catAnimal == null) {
                return new int[]{dogQueue.poll().number, DOG_TYPE};
            } else if (dogAnimal == null) {
                return new int[]{catQueue.poll().number, CAT_TYPE};
            } else {
                if (catAnimal.seq < dogAnimal.seq) {
                    return new int[]{catQueue.poll().number, CAT_TYPE};
                } else {
                    return new int[]{dogQueue.poll().number, DOG_TYPE};
                }
            }
        }

        public int[] dequeueDog() {
            AnimalSeq animalSeq = dogQueue.poll();
            if (animalSeq == null) {
                return EMPTY_RES;
            }
            return new int[]{animalSeq.number, DOG_TYPE};
        }

        public int[] dequeueCat() {
            AnimalSeq animalSeq = catQueue.poll();
            if (animalSeq == null) {
                return EMPTY_RES;
            }
            return new int[]{animalSeq.number, CAT_TYPE};
        }
    }
}
