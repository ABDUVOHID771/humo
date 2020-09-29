package com.example.springhumo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAndConfirmRequestDto {
    @JsonProperty(
            value = "card_id",
            required = true
    )
    private String cardId;
    @JsonProperty(
            value = "merchant_id",
            required = true
    )
    private String merchantId;
    @JsonProperty(
            value = "terminal_id",
            required = true
    )
    private String terminalId;
    @JsonProperty(
            value = "port",
            required = true
    )
    private Integer port;
    @JsonProperty(
            value = "amount",
            required = true
    )
    private Long amount;
    @JsonProperty(
            value = "ext",
            required = true
    )
    private String ext;
    @JsonProperty("date12")
    private String date12;
    @JsonProperty("stan")
    private String stan;

    public CreateAndConfirmRequestDto() {
    }

    public String getCardId() {
        return this.cardId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public Integer getPort() {
        return this.port;
    }

    public Long getAmount() {
        return this.amount;
    }

    public String getExt() {
        return this.ext;
    }

    public String getDate12() {
        return this.date12;
    }

    public String getStan() {
        return this.stan;
    }

    @JsonProperty(
            value = "card_id",
            required = true
    )
    public void setCardId(final String cardId) {
        this.cardId = cardId;
    }

    @JsonProperty(
            value = "merchant_id",
            required = true
    )
    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty(
            value = "terminal_id",
            required = true
    )
    public void setTerminalId(final String terminalId) {
        this.terminalId = terminalId;
    }

    @JsonProperty(
            value = "port",
            required = true
    )
    public void setPort(final Integer port) {
        this.port = port;
    }

    @JsonProperty(
            value = "amount",
            required = true
    )
    public void setAmount(final Long amount) {
        this.amount = amount;
    }

    @JsonProperty(
            value = "ext",
            required = true
    )
    public void setExt(final String ext) {
        this.ext = ext;
    }

    @JsonProperty("date12")
    public void setDate12(final String date12) {
        this.date12 = date12;
    }

    @JsonProperty("stan")
    public void setStan(final String stan) {
        this.stan = stan;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CreateAndConfirmRequestDto)) {
            return false;
        } else {
            CreateAndConfirmRequestDto other = (CreateAndConfirmRequestDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label107:
                {
                    Object this$cardId = this.getCardId();
                    Object other$cardId = other.getCardId();
                    if (this$cardId == null) {
                        if (other$cardId == null) {
                            break label107;
                        }
                    } else if (this$cardId.equals(other$cardId)) {
                        break label107;
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
                    if (other$terminalId != null) {
                        return false;
                    }
                } else if (!this$terminalId.equals(other$terminalId)) {
                    return false;
                }

                label86:
                {
                    Object this$port = this.getPort();
                    Object other$port = other.getPort();
                    if (this$port == null) {
                        if (other$port == null) {
                            break label86;
                        }
                    } else if (this$port.equals(other$port)) {
                        break label86;
                    }

                    return false;
                }

                label79:
                {
                    Object this$amount = this.getAmount();
                    Object other$amount = other.getAmount();
                    if (this$amount == null) {
                        if (other$amount == null) {
                            break label79;
                        }
                    } else if (this$amount.equals(other$amount)) {
                        break label79;
                    }

                    return false;
                }

                label72:
                {
                    Object this$ext = this.getExt();
                    Object other$ext = other.getExt();
                    if (this$ext == null) {
                        if (other$ext == null) {
                            break label72;
                        }
                    } else if (this$ext.equals(other$ext)) {
                        break label72;
                    }

                    return false;
                }

                Object this$date12 = this.getDate12();
                Object other$date12 = other.getDate12();
                if (this$date12 == null) {
                    if (other$date12 != null) {
                        return false;
                    }
                } else if (!this$date12.equals(other$date12)) {
                    return false;
                }

                Object this$stan = this.getStan();
                Object other$stan = other.getStan();
                if (this$stan == null) {
                    if (other$stan != null) {
                        return false;
                    }
                } else if (!this$stan.equals(other$stan)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CreateAndConfirmRequestDto;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $cardId = this.getCardId();
        result = result * 59 + ($cardId == null ? 43 : $cardId.hashCode());
        Object $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : $merchantId.hashCode());
        Object $terminalId = this.getTerminalId();
        result = result * 59 + ($terminalId == null ? 43 : $terminalId.hashCode());
        Object $port = this.getPort();
        result = result * 59 + ($port == null ? 43 : $port.hashCode());
        Object $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        Object $ext = this.getExt();
        result = result * 59 + ($ext == null ? 43 : $ext.hashCode());
        Object $date12 = this.getDate12();
        result = result * 59 + ($date12 == null ? 43 : $date12.hashCode());
        Object $stan = this.getStan();
        result = result * 59 + ($stan == null ? 43 : $stan.hashCode());
        return result;
    }

    public String toString() {
        return "CreateAndConfirmRequestDto(cardId=" + this.getCardId() + ", merchantId=" + this.getMerchantId() + ", terminalId=" + this.getTerminalId() + ", port=" + this.getPort() + ", amount=" + this.getAmount() + ", ext=" + this.getExt() + ", date12=" + this.getDate12() + ", stan=" + this.getStan() + ")";
    }
}
