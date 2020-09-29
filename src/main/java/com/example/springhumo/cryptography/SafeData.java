package com.example.springhumo.cryptography;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.example.springhumo.util.Trace;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SafeData<T extends Serializable> {
    private static final Logger logger = LogManager.getLogger(SafeData.class);
    private static final String SD_1 = "sd_1";
    private static final String SD_2 = "sd_2";
    private static String SECRET_KEY_1 = "dFgt89Rq_&@87Nc^";
    private static String SECRET_KEY_2 = "xZ#~098Mnf&&7?_b";
    private IvParameterSpec ivParameterSpec;
    private SecretKeySpec secretKeySpec;
    private Cipher cipher;

    public SafeData() throws Exception {
        this.ivParameterSpec = new IvParameterSpec(SECRET_KEY_1.getBytes(StandardCharsets.UTF_8));
        this.secretKeySpec = new SecretKeySpec(SECRET_KEY_2.getBytes(StandardCharsets.UTF_8), "AES");
        this.cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    private String encrypt(String toBeEncrypt) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        this.cipher.init(1, this.secretKeySpec, this.ivParameterSpec);
        byte[] encrypted = this.cipher.doFinal(toBeEncrypt.getBytes());
        return Base64.encodeBase64String(encrypted);
    }

    private String decrypt(String encrypted) throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        this.cipher.init(2, this.secretKeySpec, this.ivParameterSpec);
        byte[] decryptedBytes = this.cipher.doFinal(Base64.decodeBase64(encrypted));
        return new String(decryptedBytes);
    }

    public String safeData(T obj) throws Exception {
        String serString = Crypt.toString(obj);
        return this.encrypt(serString);
    }

    public Object unsafeData(String str) {
        try {
            String decryptedString = this.decrypt(str);
            return Crypt.fromString(decryptedString);
        } catch (Exception var3) {
            logger.error(Trace.getStackTrace(var3));
            return null;
        }
    }
}
