package com.example.springhumo.model.dto.humo.request;

import com.example.springhumo.model.dto.CreateAndConfirmRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class CreatePaymentRequestDto {
    @JsonProperty("session_id")
    private String sessionId;
    @JsonProperty("token")
    private String token;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("terminal_id")
    private String terminalId;

    public CreatePaymentRequestDto() {
    }

    public CreatePaymentRequestDto(CreateAndConfirmRequestDto createAndConfirmRequestDto) {
        this.sessionId = createAndConfirmRequestDto.getExt();
        this.token = createAndConfirmRequestDto.getCardId();
        this.amount = createAndConfirmRequestDto.getAmount().toString();
        this.merchantId = createAndConfirmRequestDto.getMerchantId();
        this.terminalId = createAndConfirmRequestDto.getTerminalId();
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getToken() {
        return this.token;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    @JsonProperty("session_id")
    public void setSessionId(final String sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("token")
    public void setToken(final String token) {
        this.token = token;
    }

    @JsonProperty("amount")
    public void setAmount(final String amount) {
        this.amount = amount;
    }

    @JsonProperty("merchant_id")
    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("terminal_id")
    public void setTerminalId(final String terminalId) {
        this.terminalId = terminalId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CreatePaymentRequestDto)) {
            return false;
        } else {
            CreatePaymentRequestDto other = (CreatePaymentRequestDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71:
                {
                    Object this$sessionId = this.getSessionId();
                    Object other$sessionId = other.getSessionId();
                    if (this$sessionId == null) {
                        if (other$sessionId == null) {
                            break label71;
                        }
                    } else if (this$sessionId.equals(other$sessionId)) {
                        break label71;
                    }

                    return false;
                }

                Object this$token = this.getToken();
                Object other$token = other.getToken();
                if (this$token == null) {
                    if (other$token != null) {
                        return false;
                    }
                } else if (!this$token.equals(other$token)) {
                    return false;
                }

                label57:
                {
                    Object this$amount = this.getAmount();
                    Object other$amount = other.getAmount();
                    if (this$amount == null) {
                        if (other$amount == null) {
                            break label57;
                        }
                    } else if (this$amount.equals(other$amount)) {
                        break label57;
                    }

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

                Object this$terminalId = this.getTerminalId();
                Object other$terminalId = other.getTerminalId();
                if (this$terminalId == null) {
                    if (other$terminalId == null) {
                        return true;
                    }
                } else if (this$terminalId.equals(other$terminalId)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CreatePaymentRequestDto;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $sessionId = this.getSessionId();
        result = result * 59 + ($sessionId == null ? 43 : $sessionId.hashCode());
        Object $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        Object $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        Object $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : $merchantId.hashCode());
        Object $terminalId = this.getTerminalId();
        result = result * 59 + ($terminalId == null ? 43 : $terminalId.hashCode());
        return result;
    }

    public String toString() {
        return "CreatePaymentRequestDto(sessionId=" + this.getSessionId() + ", token=" + this.getToken() + ", amount=" + this.getAmount() + ", merchantId=" + this.getMerchantId() + ", terminalId=" + this.getTerminalId() + ")";
    }
}
