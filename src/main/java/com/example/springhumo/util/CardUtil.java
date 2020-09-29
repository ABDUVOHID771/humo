package com.example.springhumo.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.springhumo.constant.ApiResults;
import com.example.springhumo.cryptography.SafeData;
import com.example.springhumo.model.Result;
import org.springframework.data.util.Pair;

public class CardUtil {
    private static final String tokenSalt = "uybPvjywPS";

    public CardUtil() {
    }

    public static String getBankCode(String card) {
        String bankCode = card.substring(4, 6);
        return bankCode;
    }

    public static String getGroupCode(String card) {
        return "01";
    }

    public static String generateCardToken(String cardNumber, String cardExpiry) {
        String token = UUID.nameUUIDFromBytes((cardNumber + "uybPvjywPS" + cardExpiry).getBytes()).toString();
        return token;
    }

    public static String maskPan(String pan) {
        String maskedPan = pan.substring(0, 6) + "******" + pan.substring(12, 16);
        return maskedPan;
    }

    public static Pair<Result, String> encode(String pan) {
        SafeData safeData;
        try {
            safeData = new SafeData();
        } catch (Exception var5) {
            var5.printStackTrace();
            return Pair.of(ApiResults.ERR_001, null);
        }

        String encPan;
        try {
            encPan = safeData.safeData(pan);
        } catch (Exception var4) {
            var4.printStackTrace();
            return Pair.of(ApiResults.ERR_001,null);
        }

        return Pair.of(ApiResults.OK, encPan);
    }

    public static String decode(String encPan) {
        SafeData safeData;
        try {
            safeData = new SafeData();
        } catch (Exception var5) {
            var5.printStackTrace();
            return "";
        }

        String pan = "";

        try {
            pan = (String)safeData.unsafeData(encPan);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return pan;
    }

    public static void main(String[] args) {
        System.out.println(decode("f4Fd1Uk3S9HvUH3gvnLuaiZEx7UIYl4VwBpeNBQ10i8lnVWaRaVqbbBydHD1Q47x"));
    }

    public static String maskLogString(String valueToLog) {
        Pattern p = Pattern.compile("(?:8[0-9]{12}(?:[0-9]{3})?|9[0-9]{12}(?:[0-9]{3}))");

        String masked;
        for(Matcher m = p.matcher(valueToLog); m.find(); valueToLog = valueToLog.replaceAll(m.group(), masked)) {
            masked = maskPan(m.group());
        }

        return valueToLog;
    }
}
