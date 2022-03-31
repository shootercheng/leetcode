package com.scd.exercise;

import java.util.concurrent.CountDownLatch;

/**
 * @author James
 */
public class Code1114 {

    class Foo {

        private CountDownLatch first = new CountDownLatch(1);

        private CountDownLatch second = new CountDownLatch(1);

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            first.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            first.await();
            printSecond.run();
            second.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            second.await();
            printThird.run();
        }
    }
}
