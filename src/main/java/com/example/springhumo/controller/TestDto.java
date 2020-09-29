package com.example.springhumo.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class TestDto {
    private String attr1;
    private String attr2;

    public String getAttr1() {
        return this.attr1;
    }

    public String getAttr2() {
        return this.attr2;
    }

    public void setAttr1(final String attr1) {
        this.attr1 = attr1;
    }

    public void setAttr2(final String attr2) {
        this.attr2 = attr2;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TestDto)) {
            return false;
        } else {
            TestDto other = (TestDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$attr1 = this.getAttr1();
                Object other$attr1 = other.getAttr1();
                if (this$attr1 == null) {
                    if (other$attr1 != null) {
                        return false;
                    }
                } else if (!this$attr1.equals(other$attr1)) {
                    return false;
                }

                Object this$attr2 = this.getAttr2();
                Object other$attr2 = other.getAttr2();
                if (this$attr2 == null) {
                    if (other$attr2 != null) {
                        return false;
                    }
                } else if (!this$attr2.equals(other$attr2)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TestDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $attr1 = this.getAttr1();
        result = result * 59 + ($attr1 == null ? 43 : $attr1.hashCode());
        Object $attr2 = this.getAttr2();
        result = result * 59 + ($attr2 == null ? 43 : $attr2.hashCode());
        return result;
    }

    public String toString() {
        return "TestDto(attr1=" + this.getAttr1() + ", attr2=" + this.getAttr2() + ")";
    }

    public TestDto(final String attr1, final String attr2) {
        this.attr1 = attr1;
        this.attr2 = attr2;
    }

    public TestDto() {
    }
}
