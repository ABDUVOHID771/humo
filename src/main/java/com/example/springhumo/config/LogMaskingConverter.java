package com.example.springhumo.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.springhumo.util.CardUtil;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(
        name = "LogMaskingConverter",
        category = "Converter"
)
@ConverterKeys({"spi", "trscId"})
public class LogMaskingConverter extends LogEventPatternConverter {
    private static final String CREDIT_CARD_REGEX = "([0-9]{16})";
    private static final Pattern CREDIT_CARD_PATTERN = Pattern.compile("([0-9]{16})");
    private static final String CAREDIT_CARD_REPLACEMENT_REGEX = "******";
    private static final String CVV_REGEX = "([0-9]{3})";
    private static final Pattern CVV_PATTERN = Pattern.compile("([0-9]{3})");
    private static final String CVV_REPLACEMENT_REGEX = "+++";
    private static final String SSN_REGEX = "([0-9]{9})";
    private static final Pattern SSN_PATTERN = Pattern.compile("([0-9]{9})");
    private static final String SSN_REPLACEMENT_REGEX = "*********";

    protected LogMaskingConverter(String name, String style) {
        super(name, style);
    }

    public static LogMaskingConverter newInstance(String[] options) {
        return new LogMaskingConverter("spi", Thread.currentThread().getName());
    }

    public void format(LogEvent event, StringBuilder outputMessage) {
        String message = event.getMessage().getFormattedMessage();

        String maskedMessage;
        try {
            maskedMessage = CardUtil.maskLogString(message);
        } catch (Exception var6) {
            System.out.println("Failed While Masking");
            maskedMessage = message;
        }

        outputMessage.append(maskedMessage);
    }

    private String mask(String message) {
        Matcher matcher = null;
        StringBuffer buffer = new StringBuffer();
        matcher = CREDIT_CARD_PATTERN.matcher(message);
        this.maskMatcher(matcher, buffer, "******");
        message = buffer.toString();
        buffer.setLength(0);
        matcher = SSN_PATTERN.matcher(message);
        this.maskMatcher(matcher, buffer, "*********");
        message = buffer.toString();
        buffer.setLength(0);
        matcher = CVV_PATTERN.matcher(message);
        this.maskMatcher(matcher, buffer, "+++");
        return buffer.toString();
    }

    private StringBuffer maskMatcher(Matcher matcher, StringBuffer buffer, String maskStr) {
        while (matcher.find()) {
            String masked = CardUtil.maskPan(matcher.group());
            matcher.appendReplacement(buffer, masked);
        }

        matcher.appendTail(buffer);
        return buffer;
    }
}
