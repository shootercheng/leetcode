package com.scd.contest;

import java.util.List;

/**
 * @author James
 */
public class Code5689 {

    private volatile Object object = new Object();

    public void test() throws InterruptedException {
        object.wait();
        object.notify();
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int searchIndex;
        if ("type".equalsIgnoreCase(ruleKey)) {
            searchIndex = 0;
        } else if ("color".equalsIgnoreCase(ruleKey)) {
            searchIndex = 1;
        } else if ("name".equalsIgnoreCase(ruleKey)) {
            searchIndex = 2;
        } else {
            throw new IllegalArgumentException("unknown rule key");
        }
//        object.wait();

        return  (int) items.stream().filter(item -> item.get(searchIndex).equals(ruleValue)).count();
    }

    public static void main(String[] args) throws InterruptedException {
        Code5689 code5689 = new Code5689();
        code5689.test();
    }
}
