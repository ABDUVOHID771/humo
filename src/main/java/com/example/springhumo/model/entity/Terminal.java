package com.example.springhumo.model.entity;

public class Terminal {
    private String terminalId;
    private String merchantId;

    public Terminal() {
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setTerminalId(final String terminalId) {
        this.terminalId = terminalId;
    }

    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Terminal)) {
            return false;
        } else {
            Terminal other = (Terminal) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$terminalId = this.getTerminalId();
                Object other$terminalId = other.getTerminalId();
                if (this$terminalId == null) {
                    if (other$terminalId != null) {
                        return false;
                    }
                } else if (!this$terminalId.equals(other$terminalId)) {
                    return false;
                }

                Object this$merchantId = this.getMerchantId();
                Object other$merchantId = other.getMerchantId();
                if (this$merchantId == null) {
                    if (other$merchantId != null) {
                        return false;
                    }
                } else if (!this$merchantId.equals(other$merchantId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Terminal;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $terminalId = this.getTerminalId();
        result = result * 59 + ($terminalId == null ? 43 : $terminalId.hashCode());
        Object $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : $merchantId.hashCode());
        return result;
    }

    public String toString() {
        return "Terminal(terminalId=" + this.getTerminalId() + ", merchantId=" + this.getMerchantId() + ")";
    }
}
