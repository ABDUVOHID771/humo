package com.example.springhumo.model.dto.uzCard;

import java.util.Arrays;

public class CardsGetParam {
    private String[] ids;

    public CardsGetParam() {
    }

    public String[] getIds() {
        return this.ids;
    }

    public void setIds(final String[] ids) {
        this.ids = ids;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CardsGetParam)) {
            return false;
        } else {
            CardsGetParam other = (CardsGetParam) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                return Arrays.deepEquals(this.getIds(), other.getIds());
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CardsGetParam;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        result = result * 59 + Arrays.deepHashCode(this.getIds());
        return result;
    }

    public String toString() {
        return "CardsGetParam(ids=" + Arrays.deepToString(this.getIds()) + ")";
    }
}
