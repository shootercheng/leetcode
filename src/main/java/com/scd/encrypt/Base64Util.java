package com.scd.encrypt;

import java.util.Base64;

/**
 * @author James
 */
public class Base64Util {

    public static String decrypt(String input) {
        byte[] originByteArr = Base64.getDecoder().decode(input);
        return new String(originByteArr);
    }

    public static void main(String[] args) {
        System.out.println(Base64Util.decrypt("cmFpbnltZW93MDAx"));
    }
}
