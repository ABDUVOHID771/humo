package com.example.springhumo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "terminal_id"
    )
    private String terminalId;
    @Column(
            name = "uzcard_id"
    )
    private String humoPaymentId;
    @Column(
            name = "humo_reco_status"
    )
    private Integer recoResult;
    @Column(
            name = "response_code"
    )
    private String responseCode;
    @ManyToOne
    @JoinColumn(
            name = "card_id"
    )
    private Card card;

    public Transaction() {
    }

    public Long getId() {
        return this.id;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public String getHumoPaymentId() {
        return this.humoPaymentId;
    }

    public Integer getRecoResult() {
        return this.recoResult;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public Card getCard() {
        return this.card;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setTerminalId(final String terminalId) {
        this.terminalId = terminalId;
    }

    public void setHumoPaymentId(final String humoPaymentId) {
        this.humoPaymentId = humoPaymentId;
    }

    public void setRecoResult(final Integer recoResult) {
        this.recoResult = recoResult;
    }

    public void setResponseCode(final String responseCode) {
        this.responseCode = responseCode;
    }

    public void setCard(final Card card) {
        this.card = card;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Transaction)) {
            return false;
        } else {
            Transaction other = (Transaction) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
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

                Object this$humoPaymentId = this.getHumoPaymentId();
                Object other$humoPaymentId = other.getHumoPaymentId();
                if (this$humoPaymentId == null) {
                    if (other$humoPaymentId != null) {
                        return false;
                    }
                } else if (!this$humoPaymentId.equals(other$humoPaymentId)) {
                    return false;
                }

                label62:
                {
                    Object this$recoResult = this.getRecoResult();
                    Object other$recoResult = other.getRecoResult();
                    if (this$recoResult == null) {
                        if (other$recoResult == null) {
                            break label62;
                        }
                    } else if (this$recoResult.equals(other$recoResult)) {
                        break label62;
                    }

                    return false;
                }

                label55:
                {
                    Object this$responseCode = this.getResponseCode();
                    Object other$responseCode = other.getResponseCode();
                    if (this$responseCode == null) {
                        if (other$responseCode == null) {
                            break label55;
                        }
                    } else if (this$responseCode.equals(other$responseCode)) {
                        break label55;
                    }

                    return false;
                }

                Object this$card = this.getCard();
                Object other$card = other.getCard();
                if (this$card == null) {
                    if (other$card != null) {
                        return false;
                    }
                } else if (!this$card.equals(other$card)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Transaction;
    }

    public int hashCode() {
        int PRIME = 1;// true
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $terminalId = this.getTerminalId();
        result = result * 59 + ($terminalId == null ? 43 : $terminalId.hashCode());
        Object $humoPaymentId = this.getHumoPaymentId();
        result = result * 59 + ($humoPaymentId == null ? 43 : $humoPaymentId.hashCode());
        Object $recoResult = this.getRecoResult();
        result = result * 59 + ($recoResult == null ? 43 : $recoResult.hashCode());
        Object $responseCode = this.getResponseCode();
        result = result * 59 + ($responseCode == null ? 43 : $responseCode.hashCode());
        Object $card = this.getCard();
        result = result * 59 + ($card == null ? 43 : $card.hashCode());
        return result;
    }

    public String toString() {
        return "Transaction(id=" + this.getId() + ", terminalId=" + this.getTerminalId() + ", humoPaymentId=" + this.getHumoPaymentId() + ", recoResult=" + this.getRecoResult() + ", responseCode=" + this.getResponseCode() + ", card=" + this.getCard() + ")";
    }
}
