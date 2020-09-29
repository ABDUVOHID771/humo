package com.example.springhumo.model.dto.humo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RevertRequestDto {
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("terminal_id")
    private String terminalId;
    @JsonProperty("center_id")
    private String centerId;
    @JsonProperty("payment_id")
    private String paymentId;

    public Boolean validate() {
        Boolean isValid = Boolean.TRUE;
        if (this.merchantId == null || this.terminalId == null || this.centerId == null || this.paymentId == null) {
            isValid = Boolean.FALSE;
        }

        return isValid;
    }

    public RevertRequestDto() {
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public String getCenterId() {
        return this.centerId;
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    @JsonProperty("merchant_id")
    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("terminal_id")
    public void setTerminalId(final String terminalId) {
        this.terminalId = terminalId;
    }

    @JsonProperty("center_id")
    public void setCenterId(final String centerId) {
        this.centerId = centerId;
    }

    @JsonProperty("payment_id")
    public void setPaymentId(final String paymentId) {
        this.paymentId = paymentId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RevertRequestDto)) {
            return false;
        } else {
            RevertRequestDto other = (RevertRequestDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59:
                {
                    Object this$merchantId = this.getMerchantId();
                    Object other$merchantId = other.getMerchantId();
                    if (this$merchantId == null) {
                        if (other$merchantId == null) {
                            break label59;
                        }
                    } else if (this$merchantId.equals(other$merchantId)) {
                        break label59;
                    }

                    return false;
                }

                Object this$terminalId = this.getTerminalId();
                Object other$terminalId = other.getTerminalId();
                if (this$terminalId == null) {
                    if (other$terminalId != null) {
                        return false;
                    }
                } else if (!this$terminalId.equals(other$terminalId)) {
                    return false;
                }

                Object this$centerId = this.getCenterId();
                Object other$centerId = other.getCenterId();
                if (this$centerId == null) {
                    if (other$centerId != null) {
                        return false;
                    }
                } else if (!this$centerId.equals(other$centerId)) {
                    return false;
                }

                Object this$paymentId = this.getPaymentId();
                Object other$paymentId = other.getPaymentId();
                if (this$paymentId == null) {
                    if (other$paymentId != null) {
                        return false;
                    }
                } else if (!this$paymentId.equals(other$paymentId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RevertRequestDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : $merchantId.hashCode());
        Object $terminalId = this.getTerminalId();
        result = result * 59 + ($terminalId == null ? 43 : $terminalId.hashCode());
        Object $centerId = this.getCenterId();
        result = result * 59 + ($centerId == null ? 43 : $centerId.hashCode());
        Object $paymentId = this.getPaymentId();
        result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
        return result;
    }

    public String toString() {
        return "RevertRequestDto(merchantId=" + this.getMerchantId() + ", terminalId=" + this.getTerminalId() + ", centerId=" + this.getCenterId() + ", paymentId=" + this.getPaymentId() + ")";
    }
}
