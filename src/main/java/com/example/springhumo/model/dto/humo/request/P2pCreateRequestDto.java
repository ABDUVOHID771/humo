package com.example.springhumo.model.dto.humo.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class P2pCreateRequestDto {
    @JsonProperty("card_id_from")
    private Integer cardIdFrom;
    @JsonProperty("card_id_to")
    private Integer cardIdTo;
    @JsonProperty("card_token_from")
    private String cardTokenFrom;
    @JsonProperty("card_token_to")
    private String cardTokenTo;
    @JsonProperty("amount")
    private Long amount;

    @JsonIgnore
    public Boolean isPaymentById() {
        if (this.cardIdFrom != null && this.cardIdTo != null) {
            return this.cardIdFrom != 0 && this.cardIdTo != 0 ? Boolean.TRUE : Boolean.FALSE;
        } else {
            return Boolean.FALSE;
        }
    }

    @JsonIgnore
    public Boolean isPaymentByToken() {
        if (this.cardTokenFrom != null && this.cardTokenTo != null) {
            return !this.cardTokenFrom.isEmpty() && !this.cardTokenTo.isEmpty() ? Boolean.TRUE : Boolean.FALSE;
        } else {
            return Boolean.FALSE;
        }
    }

    public P2pCreateRequestDto() {
    }

    public Integer getCardIdFrom() {
        return this.cardIdFrom;
    }

    public Integer getCardIdTo() {
        return this.cardIdTo;
    }

    public String getCardTokenFrom() {
        return this.cardTokenFrom;
    }

    public String getCardTokenTo() {
        return this.cardTokenTo;
    }

    public Long getAmount() {
        return this.amount;
    }

    @JsonProperty("card_id_from")
    public void setCardIdFrom(final Integer cardIdFrom) {
        this.cardIdFrom = cardIdFrom;
    }

    @JsonProperty("card_id_to")
    public void setCardIdTo(final Integer cardIdTo) {
        this.cardIdTo = cardIdTo;
    }

    @JsonProperty("card_token_from")
    public void setCardTokenFrom(final String cardTokenFrom) {
        this.cardTokenFrom = cardTokenFrom;
    }

    @JsonProperty("card_token_to")
    public void setCardTokenTo(final String cardTokenTo) {
        this.cardTokenTo = cardTokenTo;
    }

    @JsonProperty("amount")
    public void setAmount(final Long amount) {
        this.amount = amount;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof P2pCreateRequestDto)) {
            return false;
        } else {
            P2pCreateRequestDto other = (P2pCreateRequestDto) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71:
                {
                    Object this$cardIdFrom = this.getCardIdFrom();
                    Object other$cardIdFrom = other.getCardIdFrom();
                    if (this$cardIdFrom == null) {
                        if (other$cardIdFrom == null) {
                            break label71;
                        }
                    } else if (this$cardIdFrom.equals(other$cardIdFrom)) {
                        break label71;
                    }

                    return false;
                }

                Object this$cardIdTo = this.getCardIdTo();
                Object other$cardIdTo = other.getCardIdTo();
                if (this$cardIdTo == null) {
                    if (other$cardIdTo != null) {
                        return false;
                    }
                } else if (!this$cardIdTo.equals(other$cardIdTo)) {
                    return false;
                }

                label57:
                {
                    Object this$cardTokenFrom = this.getCardTokenFrom();
                    Object other$cardTokenFrom = other.getCardTokenFrom();
                    if (this$cardTokenFrom == null) {
                        if (other$cardTokenFrom == null) {
                            break label57;
                        }
                    } else if (this$cardTokenFrom.equals(other$cardTokenFrom)) {
                        break label57;
                    }

                    return false;
                }

                Object this$cardTokenTo = this.getCardTokenTo();
                Object other$cardTokenTo = other.getCardTokenTo();
                if (this$cardTokenTo == null) {
                    if (other$cardTokenTo != null) {
                        return false;
                    }
                } else if (!this$cardTokenTo.equals(other$cardTokenTo)) {
                    return false;
                }

                Object this$amount = this.getAmount();
                Object other$amount = other.getAmount();
                if (this$amount == null) {
                    if (other$amount == null) {
                        return true;
                    }
                } else if (this$amount.equals(other$amount)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof P2pCreateRequestDto;
    }

    public int hashCode() {
        int PRIME = 1;//true
        int result = 1;
        Object $cardIdFrom = this.getCardIdFrom();
        result = result * 59 + ($cardIdFrom == null ? 43 : $cardIdFrom.hashCode());
        Object $cardIdTo = this.getCardIdTo();
        result = result * 59 + ($cardIdTo == null ? 43 : $cardIdTo.hashCode());
        Object $cardTokenFrom = this.getCardTokenFrom();
        result = result * 59 + ($cardTokenFrom == null ? 43 : $cardTokenFrom.hashCode());
        Object $cardTokenTo = this.getCardTokenTo();
        result = result * 59 + ($cardTokenTo == null ? 43 : $cardTokenTo.hashCode());
        Object $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        return result;
    }

    public String toString() {
        return "P2pCreateRequestDto(cardIdFrom=" + this.getCardIdFrom() + ", cardIdTo=" + this.getCardIdTo() + ", cardTokenFrom=" + this.getCardTokenFrom() + ", cardTokenTo=" + this.getCardTokenTo() + ", amount=" + this.getAmount() + ")";
    }
}
