package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code1115 {

    class FooBar {
        private int n;

        private final Object object = new Object();


        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                synchronized (object) {
                    object.notify();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                synchronized (object) {
                    object.wait();
                }
                printBar.run();
            }
        }
    }
}
