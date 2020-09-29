package com.example.springhumo.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Trace {
    public Trace() {
    }

    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        t.printStackTrace(pw);
        pw.flush();
        sw.flush();
        pw.close();
        return sw.toString();
    }
}
