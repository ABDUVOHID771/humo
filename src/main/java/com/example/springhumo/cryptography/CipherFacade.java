package com.example.springhumo.cryptography;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CipherFacade {
    public CipherFacade() {
    }

    public static byte[] encryptString(String key, String toEncrypt) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(1, secretKey);
        return cipher.doFinal(toEncrypt.getBytes());
    }

    public static String decryptString(String key, byte[] encrypted) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(2, secretKey);
        return new String(cipher.doFinal(encrypted));
    }
}
