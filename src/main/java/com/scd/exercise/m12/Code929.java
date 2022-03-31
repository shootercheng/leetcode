package com.scd.exercise.m12;


import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (String email : emails) {
            char[] charArr = email.toCharArray();
            int i = 0;
            int lenc = charArr.length;
            boolean isAfterAt = false;
            while (i < lenc) {
                char curChar = charArr[i];
                if (curChar == '@') {
                    isAfterAt = true;
                }
                if (curChar == '.' && !isAfterAt) {
                    i++;
                    continue;
                }
                if (curChar == '+') {
                    while (true) {
                        if (charArr[i] == '@') {
                            isAfterAt = true;
                            break;
                        }
                        i++;
                    }
                }
                builder.append(charArr[i]);
                i++;
            }
            result.add(builder.toString());
            builder.setLength(0);
        }
        return result.size();
    }

    public static void main(String[] args) {
        Code929 code929 = new Code929();
        String[] strArr = {
        "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(code929.numUniqueEmails(strArr));
    }
}
