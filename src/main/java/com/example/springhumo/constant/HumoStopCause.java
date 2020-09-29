package com.example.springhumo.constant;

import com.example.springhumo.model.Result;

import java.util.HashMap;
import java.util.Map;

public enum HumoStopCause {
    ACTIVE(0, "ACTIVE", ApiResults.OK),
    STOLEN(1, "STOLEN", ApiResults.ERR_074),
    LOST(2, "LOST", ApiResults.ERR_073),
    NO_MONEY(3, "NO MONEY", ApiResults.ERR_057),
    PICK_UP(4, "PICK UP", ApiResults.ERR_077),
    NOT_ACTIVE(5, "NOT ACTIVE", ApiResults.ERR_079);

    private final String label;
    private final Integer Id;
    private final Result result;
    private static final Map<Integer, HumoStopCause> map = new HashMap();

    public Integer getValue() {
        return this.Id;
    }

    private HumoStopCause(Integer id, String label, Result result) {
        this.label = label;
        this.Id = id;
        this.result = result;
    }

    public static HumoStopCause findById(int Id) {
        return (HumoStopCause) map.getOrDefault(Id, NOT_ACTIVE);
    }

    public String getLabel() {
        return this.label;
    }

    public Integer getId() {
        return this.Id;
    }

    public Result getResult() {
        return this.result;
    }

    static {
        HumoStopCause[] var0 = values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            HumoStopCause r = var0[var2];
            map.put(r.getId(), r);
        }

    }
}
