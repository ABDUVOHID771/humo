package com.example.springhumo.constant;

import com.example.springhumo.constant.HumoError;

import java.util.HashMap;
import java.util.Map;

public enum HumoCardStatus {
    ACTIVE(0, "ACTIVE", HumoError.error_000),
    SUSPENDED(1, "SUSPENDED", HumoError.error_210),
    CLOSED(2, "CLOSED", HumoError.error_125);

    private final String label;
    private final Integer Id;
    private final HumoError error;
    private static final Map<Integer, HumoCardStatus> map = new HashMap();

    public Integer getValue() {
        return this.Id;
    }

    private HumoCardStatus(Integer id, String label, HumoError error) {
        this.label = label;
        this.Id = id;
        this.error = error;
    }

    public static HumoCardStatus findById(int Id) {
        return (HumoCardStatus) map.getOrDefault(Id, CLOSED);
    }

    public String getLabel() {
        return this.label;
    }

    public Integer getId() {
        return this.Id;
    }

    public HumoError getError() {
        return this.error;
    }

    static {
        HumoCardStatus[] var0 = values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            HumoCardStatus r = var0[var2];
            map.put(r.getId(), r);
        }

    }
}
