package com.scd.exercise;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

/**
 * @author James
 */
public class Code1195 {

    class FizzBuzz {
        private int n;

        private CountDownLatch fizzbuzz = new CountDownLatch(1);

        private CountDownLatch fizz = new CountDownLatch(1);

        private CountDownLatch buzz = new CountDownLatch(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            fizzbuzz.await();
            if (n % 3 == 0) {
                printFizz.run();
            }
            fizz.countDown();

        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            fizzbuzz.await();
            fizz.await();
            if (n % 5 == 0) {
                printBuzz.run();
            }
            buzz.countDown();
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            if (n % 15 == 0) {
                printFizzBuzz.run();
            }
            fizzbuzz.countDown();
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            fizzbuzz.await();
            fizz.await();
            buzz.await();
            printNumber.accept(n);
        }
    }
}
