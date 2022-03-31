package com.scd.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @author James
 */
public class ThreeDes {

    private static final String password = "21312DEDDXXzz";

    public static void main(String[] args) {
        try {
            //1.生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESEde");
            keyGenerator.init(new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();

            //2.转换KEY
            DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESEde");
            Key convertKey = factory.generateSecret(deSedeKeySpec);

            //3.加密
            Cipher cipher = Cipher.getInstance("DESEde/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertKey);
            byte[] result = cipher.doFinal(password.getBytes());
            System.out.println("加密后：" + new String(result));

            //4.解密
            cipher.init(Cipher.DECRYPT_MODE, convertKey);
            result = cipher.doFinal(result);
            System.out.println("解密后：" + new String(result));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
