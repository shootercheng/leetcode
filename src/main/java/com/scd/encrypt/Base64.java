package com.scd.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author James
 */
public class Base64 {

    public static String encrypt(byte[] msg) {
        String encrypt = new BASE64Encoder().encodeBuffer(msg);
        StringBuilder result = new StringBuilder();
        char[] encryptArr = encrypt.toCharArray();
        for (char c : encryptArr) {
            if (Character.isLetter(c)) {
                if (c == 'z') {
                    result.append('a');
                } else if (c == 'Z') {
                    result.append('A');
                } else {
                    c = (char) (c + 1);
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    //使用BASE64Decoder对象的decodeBuffer()进行解密
    public static byte[] decrypt(String str) throws IOException {
        char[] strresChar = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : strresChar) {
            if (Character.isLetter(c)) {
                if (c == 'a') {
                    stringBuilder.append('z');
                } else if (c == 'A') {
                    stringBuilder.append('Z');
                } else {
                    c = (char) (c - 1);
                    stringBuilder.append(c);
                }
            } else {
                stringBuilder.append(c);
            }
        }
        byte[] result = new BASE64Decoder().decodeBuffer(stringBuilder.toString());
        return result;
    }

    public static void main(String[] args) throws IOException {
        Base64 base64 = new Base64();
        String encrypt = Base64.encrypt("ddfsd/sdasd/123/23.html".getBytes());
        String result = new String(Base64.decrypt(encrypt));
        System.out.println(result);
    }
}
