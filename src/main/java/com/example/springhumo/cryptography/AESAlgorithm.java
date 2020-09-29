package com.example.springhumo.cryptography;

import java.nio.charset.StandardCharsets;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.example.springhumo.util.Trace;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AESAlgorithm {
    private static final Logger logger = LogManager.getLogger(AESAlgorithm.class);
    private static final String TOKEN = "ZEZnNWUxMzVlYWZjMzBlN2FjZjQ1YTMyN2RhODRkMjk5Y2E3TmNf";
    private String salt = "xZ#~098Mnf&&7?_b";
    private int pwdIterations = 65536;
    private int keySize = 256;
    private String keyAlgorithm = "AES";
    private String encryptAlgorithm = "AES/CBC/PKCS5Padding";
    private String secretKeyFactoryAlgorithm = "PBKDF2WithHmacSHA512";

    public AESAlgorithm() {
    }

    public String encrypt(String plainText, IvParameterSpec ivParameterSpec) throws Exception {
        byte[] saltBytes = this.salt.getBytes(StandardCharsets.UTF_8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(this.secretKeyFactoryAlgorithm);
        PBEKeySpec spec = new PBEKeySpec("ZEZnNWUxMzVlYWZjMzBlN2FjZjQ1YTMyN2RhODRkMjk5Y2E3TmNf".toCharArray(), saltBytes, this.pwdIterations, this.keySize);
        SecretKey secretKey = skf.generateSecret(spec);
        SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), this.keyAlgorithm);
        Cipher cipher = Cipher.getInstance(this.encryptAlgorithm);
        cipher.init(1, key, ivParameterSpec);
        byte[] encryptedText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return (new Base64()).encodeAsString(encryptedText);
    }

    public String decrypt(String encryptText, IvParameterSpec ivParameterSpec) throws Exception {
        byte[] saltBytes = this.salt.getBytes(StandardCharsets.UTF_8);
        byte[] encryptTextBytes = (new Base64()).decode(encryptText);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(this.secretKeyFactoryAlgorithm);
        PBEKeySpec spec = new PBEKeySpec("ZEZnNWUxMzVlYWZjMzBlN2FjZjQ1YTMyN2RhODRkMjk5Y2E3TmNf".toCharArray(), saltBytes, this.pwdIterations, this.keySize);
        SecretKey secretKey = skf.generateSecret(spec);
        SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), this.keyAlgorithm);
        Cipher cipher = Cipher.getInstance(this.encryptAlgorithm);
        cipher.init(2, key, ivParameterSpec);
        byte[] decyrptTextBytes = null;

        try {
            decyrptTextBytes = cipher.doFinal(encryptTextBytes);
        } catch (BadPaddingException | IllegalBlockSizeException var12) {
            logger.error(Trace.getStackTrace(var12));
        }

        return decyrptTextBytes != null ? new String(decyrptTextBytes) : null;
    }
}
