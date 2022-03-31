package com.scd.study.exception;

/**
 * @author James
 */
public class ExceptionTest {

    public void catchError(int i) {
        try {
            if (i == 0) {
                throw new RuntimeException("xxxxx");
            }
        } finally {
            System.out.println("finally");
        }
        System.out.println("OK");
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.catchError(0);
    }
}
