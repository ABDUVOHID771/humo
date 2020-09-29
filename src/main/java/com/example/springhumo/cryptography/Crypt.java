package com.example.springhumo.cryptography;

import com.example.springhumo.util.Trace;
import com.thoughtworks.xstream.core.util.Base64Encoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Formatter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Crypt {
    public static final String key = "Ti0zMThvNTEwOWZnMDc0UnUyNjd2bjU1NEw=";
    private static final Logger logger = LogManager.getLogger(Crypt.class);
    private static final String ALGO = "AES";
    private static final byte[] keyValue = "Ti0zMThvNTEwOWZnMDc0UnUyNjd2bjU1NEw=".getBytes();

    public Crypt() {
    }

    private static String convertToHex(final byte[] data) {
        StringBuilder buf = new StringBuilder();
        byte[] var2 = data;
        int var3 = data.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte aData = var2[var4];
            int halfbyte = aData >>> 4 & 15;
            int var7 = 0;

            do {
                if (0 <= halfbyte && halfbyte <= 9) {
                    buf.append((char)(48 + halfbyte));
                } else {
                    buf.append((char)(97 + (halfbyte - 10)));
                }

                halfbyte = aData & 15;
            } while(var7++ < 1);
        }

        return buf.toString();
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        byte[] var2 = hash;
        int var3 = hash.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            formatter.format("%02x", b);
        }

        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public static String SHA256(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        Base64Encoder base64Encoder = new Base64Encoder();
        return base64Encoder.encode(hash);
    }

    public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return DigestUtils.sha1Hex(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String SHA1_(String text) throws UnsupportedEncodingException {
        return DigestUtils.sha1Hex(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String encryptString(String str) {
        String sha1 = "";

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(str.getBytes(StandardCharsets.UTF_8));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException var3) {
            logger.error(Trace.getStackTrace(var3));
        }

        return sha1;
    }

    static Object fromString(String s) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

    public static String toString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String password = "111111";
        System.out.println(SHA256(password));
    }

    public static String MD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return DigestUtils.md5Hex(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String MD5_____(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return DigestUtils.md5Hex(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String MD5_(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(text.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        return number.toString(16);
    }

    public static String MD5__(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];
        md.update(text.getBytes(StandardCharsets.UTF_8), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }
}
