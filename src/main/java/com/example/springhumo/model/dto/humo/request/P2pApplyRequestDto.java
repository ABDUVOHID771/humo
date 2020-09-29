package com.example.springhumo.model.dto.humo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class P2pApplyRequestDto {
    @JsonProperty("payment_id")
    private Integer paymentId;

    public P2pApplyRequestDto() {
    }

    public Integer getPaymentId() {
        return this.paymentId;
    }

    @JsonProperty("payment_id")
    public void setPaymentId(final Integer paymentId) {
        this.paymentId = paymentId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof P2pApplyRequestDto)) {
            return false;
        } else {
            P2pApplyRequestDto other = (P2pApplyRequestDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
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
        return other instanceof P2pApplyRequestDto;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $paymentId = this.getPaymentId();
        result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
        return result;
    }

    public String toString() {
        return "P2pApplyRequestDto(paymentId=" + this.getPaymentId() + ")";
    }
}
