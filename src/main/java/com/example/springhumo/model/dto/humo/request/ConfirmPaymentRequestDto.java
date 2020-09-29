package com.example.springhumo.model.dto.humo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ConfirmPaymentRequestDto {
    @JsonProperty("session_id")
    private String sessionId;
    @JsonProperty("payment_id")
    private Integer paymentId;

    public ConfirmPaymentRequestDto() {
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public Integer getPaymentId() {
        return this.paymentId;
    }

    @JsonProperty("session_id")
    public void setSessionId(final String sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("payment_id")
    public void setPaymentId(final Integer paymentId) {
        this.paymentId = paymentId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ConfirmPaymentRequestDto)) {
            return false;
        } else {
            ConfirmPaymentRequestDto other = (ConfirmPaymentRequestDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$sessionId = this.getSessionId();
                Object other$sessionId = other.getSessionId();
                if (this$sessionId == null) {
                    if (other$sessionId != null) {
                        return false;
                    }
                } else if (!this$sessionId.equals(other$sessionId)) {
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
        return other instanceof ConfirmPaymentRequestDto;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $sessionId = this.getSessionId();
        result = result * 59 + ($sessionId == null ? 43 : $sessionId.hashCode());
        Object $paymentId = this.getPaymentId();
        result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
        return result;
    }

    public String toString() {
        return "ConfirmPaymentRequestDto(sessionId=" + this.getSessionId() + ", paymentId=" + this.getPaymentId() + ")";
    }
}
